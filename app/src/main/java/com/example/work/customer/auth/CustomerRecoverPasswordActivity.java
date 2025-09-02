package com.example.work.customer.auth;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.work.R;
import com.example.work.login.LoginActivity;

public class CustomerRecoverPasswordActivity extends AppCompatActivity {
    private EditText emailEditText;
    private Button getCodeButton;
    private View arrowBack;
    private TextView emailErrorMessage;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_recover_password);

//        intiView();
        emailEditText = findViewById(R.id.et_customer_recover);
        getCodeButton = findViewById(R.id.customer_recovery_password_button);
        arrowBack = findViewById(R.id.view_back_arrow);
        emailErrorMessage = findViewById(R.id.tv_email_error_massage);
        initListener();
        textListener();
        enableDisableButton();
    }


    private void intiView() {
        emailEditText = findViewById(R.id.et_customer_recover);
        getCodeButton = findViewById(R.id.customer_recovery_password_button);
        arrowBack = findViewById(R.id.view_back_arrow);
        emailErrorMessage = findViewById(R.id.tv_email_error_massage);
    }
    private void initListener() {
        getCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.length() > 0) {
                    validateEmail(email);

                    Intent myIntent = new Intent(CustomerRecoverPasswordActivity.this, CustomerVerificationCodeActivity.class);
                    startActivity(myIntent);

                } else {
                    Toast.makeText(CustomerRecoverPasswordActivity.this, "field is empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CustomerRecoverPasswordActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });

    }

    private void textListener() {

        emailTextChangeListener();
    }

    private void emailTextChangeListener() {
    emailEditText.addTextChangedListener(new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
         email = editable.toString();
            validateEmail(email);
            enableDisableButton();
        }
       });


    }

    private void validateEmail(String email) {
        boolean isValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

        if (email.length() < 8) {
            isValid = false;
        }

        if (isValid) {
            // Email address is valid
            emailErrorMessage.setText(null);
            enableDisableButton();
        }
        else{
            // Email address is invalid
            emailErrorMessage.setText("Please enter a valid email address.");
        }
    }


    private void enableDisableButton() {
        if (email != null) {
            getCodeButton.setEnabled(true);
            getCodeButton.setBackground(getResources().getDrawable(R.drawable.purple_button));
        } else {
            getCodeButton.setEnabled(false);
            getCodeButton.setBackground(getResources().getDrawable(R.drawable.disable_button));
        }
    }
}