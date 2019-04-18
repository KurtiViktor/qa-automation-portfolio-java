package test_engine.api.rest.retrofit;

import io.qameta.allure.okhttp3.AllureOkHttp3;
import lombok.experimental.UtilityClass;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * Класс общей конфигурации параметров библиотеки Retrofit.
 */
@UtilityClass
public class RetrofitAdapter {

    /**
     * Метод конфигурирования и построения класса с запросами.
     *
     * @param baseUrl the base url
     * @return Обхект класса с запросами
     */
    public APIRequests build(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
        return retrofit.create(APIRequests.class);
    }

    private OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AllureOkHttp3())
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

}
