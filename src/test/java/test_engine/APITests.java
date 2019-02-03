package test_engine;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import retrofit2.Call;
import retrofit2.Response;
import test_engine.api.rest.retrofit.APIRequests;
import test_engine.api.rest.retrofit.model.UserData;
import test_engine.api.testdata.model.TestData;
import test_engine.ext.junit5.interf.API;
import test_engine.ext.junit5.interf.JsonFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Юнит-тесты для проверки api-функциональности.
 */
@API
@Slf4j
@DisplayName("Юнит-тесты для проверки api-функциональности")
class APITests {

    /**
     * Фикстура перед всеми api тестами.
     */
    @BeforeAll
    @DisplayName("Фикстура перед всеми api тестами")
    static void setUp() {
        log.info("Фикстура перед всеми api тестами " + Thread.currentThread().getName());
    }

    /**
     * Тест запроса одиночного пользователя.
     *
     * @param td  тестовые данные
     * @param api класс с запросами апи
     * @throws IOException the io exception
     */
    @ParameterizedTest(name = "Запрос одиночного пользователя")
    @JsonFileSource(filePath = "/testdata/api1.json")
    void singleUserApiTest(TestData td, APIRequests api) throws IOException {
        Response<UserData> response = sendRequest(td.getUser_id(), api);
        UserData userData = response.body();
        assertNotNull(userData, "Сервер не ответил или произошла ошибка автотестов " + response.code());
        assertAll("response check",
                () -> assertEquals(response.code(), td.getResponse_status()),
                () -> assertEquals(userData.getData(), td.getResponse().getData())
        );
    }

    /**
     * Тест битого запроса одиночного пользователя.
     *
     * @param td  тестовые данные
     * @param api класс с запросами апи
     * @throws IOException the io exception
     */
    @ParameterizedTest(name = "Битый запрос одиночного пользователя")
    @JsonFileSource(filePath = "/testdata/api2.json")
    void singleUserNotFoundApiTest(TestData td, APIRequests api) throws IOException {
        Response<UserData> response = sendRequest(td.getUser_id(), api);
        UserData userData = response.body();
        assertNotNull(userData, "Сервер не ответил или произошла ошибка автотестов " + response.code());
        assertAll("response check",
                () -> assertEquals(response.code(), td.getResponse_status()),
                () -> assertEquals(userData.getData(), td.getResponse().getData())
        );
    }

    /**
     * Шаг установки текста {text} на поиск.
     *
     * @param id  тестовые данные
     * @param api класс с запросами апи
     * @return the response
     * @throws IOException the io exception
     */
    @Step("Задать текст {text} на поиск")
    Response<UserData> sendRequest(String id, APIRequests api) throws IOException {
        log.info("запрос одиночного пользователя " + Thread.currentThread().getName());
        Call<UserData> callSync = api.getUserData(id);
        return callSync.execute();
    }

}
