package com.bpn8adh.bankaksassessment.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bpn8adh.bankaksassessment.Constants;
import com.bpn8adh.bankaksassessment.FormComponentProvider;
import com.bpn8adh.bankaksassessment.model.ApiResponseModel;
import com.bpn8adh.bankaksassessment.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class FormActivity extends AppCompatActivity implements View.OnClickListener {

    private String screenTitle;
    private List<ApiResponseModel.UiType.Value> valuesObjectList;
    private String value;
    private ArrayList<String> valueList = new ArrayList();
    private Button buttonSubmit;

    private List<View> viewList;
    private ApiResponseModel.Result dynamicData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        viewList = new ArrayList<>();

        buttonSubmit = findViewById(R.id.form_button_submit);
        buttonSubmit.setOnClickListener(this);

        LinearLayout layout = findViewById(R.id.ll_form);

        Bundle bundle = getIntent().getExtras();
        dynamicData = (ApiResponseModel.Result) bundle.getSerializable("OPTION_VALUE");

        screenTitle = dynamicData.getScreenTitle();
        setTitle(screenTitle);

        List<ApiResponseModel.Field> fieldList = dynamicData.getFields();

        for (ApiResponseModel.Field field : fieldList) {
            boolean typeNumber = false;
            if (field.getType().getDataType().equalsIgnoreCase("int")) {
                typeNumber = true;
            }

            // Title for every Edit Text input field
            TextView textview = FormComponentProvider.getTextView(this, field.getPlaceholder());
            layout.addView(textview);

            switch (field.getUiType().getType()) {
                case Constants.TEXT_FIELD:
                    EditText editText = FormComponentProvider.getEditText(this, field.getHintText(), typeNumber);
                    layout.addView(editText);
                    viewList.add(editText);
                    break;

                case Constants.DROP_DOWN:
                    valueList = getValueList(field);
                    Spinner spinner = FormComponentProvider.getSpinner(this, valueList);
                    layout.addView(spinner);
                    viewList.add(spinner);
                    break;
            }

        }
    }

    private ArrayList<String> getValueList(ApiResponseModel.Field field) {
        valuesObjectList = field.getUiType().getValues();
        for (ApiResponseModel.UiType.Value valueObject : valuesObjectList) {
            value = valueObject.getName();
            valueList.add(value);
        }
        return valueList;
    }

    @Override
    public void onClick(View view) {
        if (validationSuccess()) {
            Toast.makeText(FormActivity.this, Constants.SUCCESS, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(FormActivity.this, Constants.FAILED, Toast.LENGTH_LONG).show();
        }
    }

    private boolean validationSuccess() {

        boolean loopBreak = false;
        List<ApiResponseModel.Field> fieldList = dynamicData.getFields();
        for (int i = 0; i < fieldList.size(); i++) {
            switch (fieldList.get(i).getUiType().getType()) {
                case Constants.TEXT_FIELD:
                    EditText editText = (EditText) viewList.get(i);
                    if (!validateEditText(editText, fieldList.get(i))) {
                        loopBreak = true;
                    }
                    break;
            }

        }
        return !loopBreak;
    }

    private boolean validateEditText(EditText editText, ApiResponseModel.Field field) {
        try {
            if (editText.getText().toString().isEmpty()) {
                editText.setError(getResources().getString(R.string.error_msg_empty_field));
                return false;
            }

            if (!Pattern.matches(field.getRegex(), editText.getText()) && !field.getRegex().isEmpty()) {
                editText.setError(getResources().getString(R.string.error_msg_invalid_input));
                return false;
            }

            return true;
        } catch (Exception ex) {
            editText.setError(getResources().getString(R.string.error_msg_server));
            return false;
        }
    }


}