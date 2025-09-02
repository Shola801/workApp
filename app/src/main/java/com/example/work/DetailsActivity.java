package com.example.work;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.work.utility.AppPreferenceHelper;
import com.example.work.utility.SaveValues;

public class DetailsActivity extends AppCompatActivity {

   private  TextView emailTextView, passwordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initView();
    }

    private void initView() {
        emailTextView = findViewById(R.id.tv_email);
        passwordTextView = findViewById(R.id.tv_password);


        getValueSaved();
    }

    private void getValueSaved() {

        SaveValues myValue = new SaveValues(this);
        String email = myValue.getStringPrefValue(AppPreferenceHelper.EMAIL_ADDRESS);
        String password = myValue.getStringPrefValue(AppPreferenceHelper.PASSWORD);


        emailTextView.setText(email);
        passwordTextView.setText(password);
    }
}