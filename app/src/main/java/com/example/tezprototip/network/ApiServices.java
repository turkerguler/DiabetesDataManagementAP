package com.example.tezprototip.network;

import com.example.tezprototip.model.User;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("index.php")
    Call<User> insertUser(@Field("TC") int TC, @Field("SIFRE") int SIFRE, @Field("AD") String AD, @Field("SOYAD") String SOYAD,
                          @Field("DOGUM_TARIHI") Date DOGUM_TARIHI, @Field("CINSIYET") String CINSIYET);

}
