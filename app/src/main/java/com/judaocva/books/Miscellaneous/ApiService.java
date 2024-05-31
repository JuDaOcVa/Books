package com.judaocva.books.Miscellaneous;

import com.judaocva.books.Login.Dto.CreateAppKeyResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("api.php")
    Call<CreateAppKeyResponse> createAppKey(@Field("version") String version,
                                            @Field("req") String req,
                                            @Field("appname") String appname);
}