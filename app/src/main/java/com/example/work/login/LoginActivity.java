package com.example.work.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.work.R;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout serviceProviderLayout, customerLayout;
    private TextView serviceProviderText, customerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();
    }
    private void initView() {
        serviceProviderLayout = findViewById(R.id.layout_service_provider);
        customerLayout = findViewById(R.id.layout_customer);
        serviceProviderText = findViewById(R.id.tv_service_provider_active);
        customerText = findViewById(R.id.tv_customer_active);

        startFragment();
    }

    private void startFragment() {
        FragmentManager myFragmentManager = getSupportFragmentManager();
        FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();
        ServiceProviderFragment myServiceProviderFragment = new ServiceProviderFragment();
        myFragmentTransaction.add(R.id.fragment_container, myServiceProviderFragment).commit();

    }

    private void initListener() {
     serviceProvider();
     customer();
    }

    private void serviceProvider() {
        serviceProviderText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                serviceProviderLayout.setVisibility(View.VISIBLE);
                customerLayout.setVisibility(View.INVISIBLE);

                FragmentManager myFragmentManager = getSupportFragmentManager();
                FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();
                ServiceProviderFragment myServiceProviderFragment = new ServiceProviderFragment();
                myFragmentTransaction.replace(R.id.fragment_container, myServiceProviderFragment).commit();

            }
        });
    }

    private void customer() {
        customerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                serviceProviderLayout.setVisibility(View.INVISIBLE);
                customerLayout.setVisibility(View.VISIBLE);

                FragmentManager myFragmentManager = getSupportFragmentManager();
                FragmentTransaction myFragmentTransaction = myFragmentManager.beginTransaction();
                CustomerFragment myCustomerFragment = new CustomerFragment();
                myFragmentTransaction.replace(R.id.fragment_container, myCustomerFragment).commit();
            }
        });
    }

}