package com.example.work.serviceProvider.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.work.R;

public class ServiceProviderRecoverPasswordActivity extends AppCompatActivity {

    private EditText emailEditText, getCodeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider_recover_password);
    }
}