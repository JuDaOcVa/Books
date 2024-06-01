package com.judaocva.books.Login.Service;

import com.judaocva.books.Login.Dto.CreateAppKeyResponse;
import com.judaocva.books.Login.Dto.CreateOAuthKeyResponse;
import com.judaocva.books.Login.Dto.CreateSessKeyResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServiceLogin {
    @FormUrlEncoded
    @POST("api.php")
    Call<CreateAppKeyResponse> createAppKey(@Field("version") String version,
                                            @Field("req") String req,
                                            @Field("appname") String appname);

    @FormUrlEncoded
    @POST("api.php")
    Call<CreateOAuthKeyResponse> createOauthKey(@Field("version") String version,
                                                @Field("req") String req,
                                                @Field("login") String login,
                                                @Field("pwd") String pwd,
                                                @Field("appkey") String appkey);

    @FormUrlEncoded
    @POST("api.php")
    Call<CreateSessKeyResponse> createSessKey(@Field("version") String version,
                                              @Field("req") String req,
                                              @Field("o_u") String o_u,
                                              @Field("u_c") String u_c,
                                              @Field("oauthkey") String oauthkey);

}