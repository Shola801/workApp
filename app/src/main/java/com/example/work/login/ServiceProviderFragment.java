package com.example.work.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.work.R;
import com.example.work.serviceProvider.auth.ServiceProviderRecoverPasswordActivity;
import com.example.work.signUp.SignUpActivity;


public class ServiceProviderFragment extends Fragment {

    private View myView;
    private EditText emailEditText, passwordEditText;
    private TextView forgetPasswordText, signUpText;
    private Button loginButton;

    private TextView emailErrorMessage, passwordErrorMessage;

    String email, password;



    public ServiceProviderFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        myView = inflater.inflate(R.layout.fragment_service_provider, container, false);

        initComponent();
        return myView;
    }

    private void initComponent() {
        initView();
        initListener();
        enableDisableButton();
        initListener();
    }

    private void initView() {
        emailEditText = myView.findViewById(R.id.et_email);
        passwordEditText = myView.findViewById(R.id.et_password);
        forgetPasswordText = myView.findViewById(R.id.tv_forget_password);
        loginButton = myView.findViewById(R.id.btn_login);
        signUpText = myView.findViewById(R.id.tv_sign_up);
        emailErrorMessage = myView.findViewById(R.id.tv_email_error_message_service);
        passwordErrorMessage = myView.findViewById(R.id.tv_error_password);
    }

    private void initListener() {
        forgetPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(getActivity(), ServiceProviderRecoverPasswordActivity.class);
                startActivity(myIntent);
            }
        });


        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(getActivity(), SignUpActivity.class);
                startActivity(myIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.length() > 0 && password.length() > 0) {
                    validateEmail(email);
                    validatePassword(password);

//                    Intent myIntent = new Intent(ServiceProviderPasswordActivity.this, ServiceProviderVerificationCodeActivity.class);
//                    startActivity(myIntent);

                } else {
                    Toast.makeText(getActivity(), "field is empty", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }


    private void textListener() {
        emailTextListener();
        passwordTextListener();
    }

    private void emailTextListener() {
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                email = editable.toString().trim();
                validateEmail(email);
                enableDisableButton();
            }

        });
    }

    private void passwordTextListener() {
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                password = editable.toString().trim();
                validatePassword(password);
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


    private void validatePassword(String password) {
        boolean isValid = true;

        // Check length
        if (password.length() < 8) {
            isValid = false;
        }

        if (isValid) {
            passwordErrorMessage.setText(null);
            enableDisableButton();
            // Password is valid
        } else {
            // Password is invalid
            passwordErrorMessage.setText("Password must be at least 8 characters long");

        }
    }


    private void enableDisableButton() {
        if (email != null && password != null && password.length() > 7 && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginButton.setEnabled(true);
            loginButton.setBackground(getResources().getDrawable(R.drawable.purple_button));
        } else {
            loginButton.setEnabled(false);
            loginButton.setBackground(getResources().getDrawable(R.drawable.disable_button));
        }
    }
}