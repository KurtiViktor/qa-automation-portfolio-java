package test_engine.api.rest.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import test_engine.api.rest.retrofit.model.UserData;

public interface APIRequests {

    @GET("/api/users/{id}")
    Call<UserData> getUserData(@Path("id") String id);

}
