package com.bpn8adh.bankaksassessment.providers;

import android.content.Context;

import com.bpn8adh.bankaksassessment.Constants;
import com.bpn8adh.bankaksassessment.R;
import com.bpn8adh.bankaksassessment.model.ApiResponseModel;
import com.bpn8adh.bankaksassessment.network.ApiClient;
import com.bpn8adh.bankaksassessment.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataProvider {
    private Context context;
    private ApiInterface apiInterface;

    public RemoteDataProvider(Context context) {
        this.context = context;
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getDataFromAPI(int index, final RemoteDataFetchListener remoteDataFetchListener) {
        apiInterface.getOptionDetails(index).enqueue(
                new Callback<ApiResponseModel>() {
                    @Override
                    public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                        if (response.isSuccessful()) {
                            if (response.body().getMessage().equals(Constants.SUCCESS))
                                remoteDataFetchListener.onSuccess(response.body().getResult());
                            else
                                remoteDataFetchListener.onFailure(response.body().getMessage());
                        } else
                            remoteDataFetchListener.onFailure(context.getResources().getString(R.string.error_msg_network));
                    }

                    @Override
                    public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                        remoteDataFetchListener.onFailure(context.getString(R.string.error_msg_network));
                    }
                }
        );
    }
}
