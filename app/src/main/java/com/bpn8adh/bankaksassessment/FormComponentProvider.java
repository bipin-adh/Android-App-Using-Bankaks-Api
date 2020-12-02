package com.bpn8adh.bankaksassessment;

import android.content.Context;
import android.graphics.Typeface;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FormComponentProvider {

    private static LinearLayout.LayoutParams params;

    static {
        params = new LinearLayout.LayoutParams(
                android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, 8);
    }

    public static EditText getEditText(Context context, String hintText, boolean typeNumber) {
        EditText edittext = new EditText(context);
        edittext.setHint(hintText);
        edittext.setLayoutParams(params);
        edittext.setSingleLine(true);
        edittext.setImeOptions(EditorInfo.IME_ACTION_DONE);
        if (typeNumber)
            edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
        return edittext;
    }

    public static Spinner getSpinner(Context context, List valueList) {
        Spinner spinner = new Spinner(context);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, valueList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setLayoutParams(params);
        return spinner;
    }

    public static TextView getTextView(Context context, String fieldTitle) {
        TextView textView = new TextView(context);
        textView.setText(fieldTitle);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(params);
        return textView;
    }

}