package com.greenfox.pkrisz0.pkrisz0chatapp.retrofit;

import com.greenfox.pkrisz0.pkrisz0chatapp.model.Message;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Sir Robin on 2017. 11. 16..
 */

public interface ApiService {
    @GET("/api/messages")
    Call<MessageResponse> getMessages();

    @POST("/api/messages")
    Call<StatusResponse> postMessage(@Body Message message);
}
