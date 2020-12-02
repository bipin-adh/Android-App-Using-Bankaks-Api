package com.bpn8adh.bankaksassessment.providers;

import com.bpn8adh.bankaksassessment.model.ApiResponseModel;

public interface RemoteDataFetchListener {
    void onSuccess(ApiResponseModel.Result result);

    void onFailure(String errorMessage);
}
