package com.example.test_meowbottomnav.api;

import com.example.test_meowbottomnav.entities.Customers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    /*setup call api
        url: http://192.168.43.167:8080/
        trong đó:http://192.168.43.167 : lấy từ wifi ipv4 của thiết bị
        các lấy ipv4: cmd -> ipconfig -> tìm mục " Wireless LAN adapter Wi-Fi: " ->  IPv4 Address. . . . . . . . . . . : 192.168.1.3
    */
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.43.167:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("hello")
    Call<Customers> getUserfromApi();
}
