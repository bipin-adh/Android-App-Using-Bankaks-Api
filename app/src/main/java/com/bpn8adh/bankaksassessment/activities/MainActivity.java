package com.bpn8adh.bankaksassessment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.bpn8adh.bankaksassessment.model.ApiResponseModel;
import com.bpn8adh.bankaksassessment.R;
import com.bpn8adh.bankaksassessment.providers.RemoteDataFetchListener;
import com.bpn8adh.bankaksassessment.providers.RemoteDataProvider;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button proceedButton;
    private Spinner optionsSpinner;
    private ProgressDialog progressDialog;

    private RemoteDataProvider remoteDataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionsSpinner = findViewById(R.id.options_spinner);
        proceedButton = findViewById(R.id.proceed_button);

        proceedButton.setOnClickListener(this);
        remoteDataProvider = new RemoteDataProvider(this);
        initSpinner();

    }


    private void initSpinner() {
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        optionsSpinner.setAdapter(adapter);
        optionsSpinner.setPrompt(getResources().getString(R.string.prompt_msg_dropdown));
    }

    /**
     * proceed button click listener
     *
     * @param view - proceed button view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.proceed_button:
                loadRemoteData();
                break;
            default:
                break;
        }

    }

    private void loadRemoteData() {
        showProgressDialog();
        remoteDataProvider.getDataFromAPI(optionsSpinner.getSelectedItemPosition() + 1, new RemoteDataFetchListener() {
            @Override
            public void onSuccess(ApiResponseModel.Result result) {
                hideProgressDialog();
                Bundle bundle = new Bundle();
                bundle.putSerializable("OPTION_VALUE", result);

                Intent intent = new Intent(getApplicationContext(), FormActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            public void onFailure(String errorMessage) {
                hideProgressDialog();
                Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getResources().getString(R.string.progress_loading_title));
        progressDialog.setMessage(getResources().getString(R.string.progress_loading_msg));
        progressDialog.show();
    }

    private void hideProgressDialog() {
        if (progressDialog != null)
            progressDialog.hide();
    }
}