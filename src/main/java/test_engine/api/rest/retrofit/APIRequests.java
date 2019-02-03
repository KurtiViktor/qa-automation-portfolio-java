package test_engine.api.rest.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import test_engine.api.rest.retrofit.model.UserData;

/**
 * Класс запросов к апи через библиотеку Retrofit.
 */
public interface APIRequests {

    /**
     * Запрос данных пользователей по id.
     *
     * @param id the id
     * @return объект класса UserData
     */
    @GET("/api/users/{id}")
    Call<UserData> getUserData(@Path("id") String id);

}
