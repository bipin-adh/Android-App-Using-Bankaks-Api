package com.bpn8adh.bankaksassessment.network;

import com.bpn8adh.bankaksassessment.model.ApiResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("task/{type}")
    Call<ApiResponseModel> getOptionDetails(@Path("type") int type);

}
