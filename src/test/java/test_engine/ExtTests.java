package test_engine;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.params.ParameterizedTest;
import retrofit2.Call;
import retrofit2.Response;
import ru.lanwen.wiremock.ext.WiremockResolver;
import ru.lanwen.wiremock.ext.WiremockUriResolver;
import test_engine.api.rest.retrofit.APIRequests;
import test_engine.api.rest.retrofit.RetrofitAdapter;
import test_engine.api.rest.retrofit.model.UserData;
import test_engine.api.testdata.model.TestData;
import test_engine.ext.junit5.JsonFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Tag("ext")
@Execution(CONCURRENT)
@ExtendWith({
        WiremockResolver.class,
        WiremockUriResolver.class
})
@DisplayName("Юнит-тесты для проверки функциональности из расширений")
class ExtTests {

    @BeforeAll
    @DisplayName("Фикстура перед всеми api тестами")
    static void setUp() {
        System.out.println("Фикстура перед всеми ext тестами " + Thread.currentThread().getName());
    }

    @ParameterizedTest(name = "Запрос одиночного пользователя")
    @JsonFileSource(filePath = "/testdata/api1.json")
    void singleUserApiTest(
            TestData td,
            @WiremockResolver.Wiremock WireMockServer server,
            @WiremockUriResolver.WiremockUri String uri) throws IOException {
        APIRequests api = RetrofitAdapter.build(uri);
        Response<UserData> response = sendRequest(td.getUser_id(), api);
        UserData userData = response.body();
        assertNotNull(userData, "Сервер не ответил или произошла ошибка автотестов " + response.code());
        assertAll("response check",
                () -> assertEquals(response.code(), td.getResponse_status()),
                () -> assertEquals(userData.getData(), td.getResponse().getData())
        );
    }

    @ParameterizedTest(name = "Битый запрос одиночного пользователя")
    @JsonFileSource(filePath = "/testdata/api2.json")
    void singleUserNotFoundApiTest(
            TestData td,
            @WiremockResolver.Wiremock WireMockServer server,
            @WiremockUriResolver.WiremockUri String uri) throws IOException {
        APIRequests api = RetrofitAdapter.build(uri);
        Response<UserData> response = sendRequest(td.getUser_id(), api);
        UserData userData = response.body();
        assertNotNull(userData, "Сервер не ответил или произошла ошибка автотестов " + response.code());
        assertAll("response check",
                () -> assertEquals(response.code(), td.getResponse_status()),
                () -> assertEquals(userData.getData(), td.getResponse().getData())
        );
    }

    @Step("Задать текст {text} на поиск")
    Response<UserData> sendRequest(String id, APIRequests api) throws IOException {
        System.out.println("запрос одиночного пользователя " + Thread.currentThread().getName());
        Call<UserData> callSync = api.getUserData(id);
        return callSync.execute();
    }

}
