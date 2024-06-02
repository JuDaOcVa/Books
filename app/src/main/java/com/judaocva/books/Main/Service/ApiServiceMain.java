package com.judaocva.books.Main.Service;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceMain {
    @FormUrlEncoded
    @POST("api.php")
    Call<JsonObject> getAllBooks(@Field("version") String version,
                                 @Field("req") String req,
                                 @Field("u_c") String u_c,
                                 @Field("o_u") String o_u,
                                 @Field("sesskey") String sesskey);
}
