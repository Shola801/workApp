package com.example.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ServiceScreenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ServiceScreenAdapter adapter;
    private ArrayList<ServiceScreenModel> serviceScreenModels = new ArrayList<>();
    private View arrowBack, notification, searchSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_screen);

        initView();
        recyclerView();
        initListener();
    }
    private void initView() {
     recyclerView = findViewById(R.id.recycler_view);
     arrowBack = findViewById(R.id.view_back_button);

    }
    private void recyclerView() {
        recyclerView.setHasFixedSize(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ServiceScreenActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ServiceScreenAdapter(ServiceScreenActivity.this, serviceScreenModels);
        // Add some profiles
        serviceScreenModels.add(new ServiceScreenModel("Bryan Aikhenomian", R.drawable.pic_one));
        serviceScreenModels.add(new ServiceScreenModel("John Doe", R.drawable.pic_two));
        serviceScreenModels.add(new ServiceScreenModel("Jane Smith", R.drawable.pic_three));
        serviceScreenModels.add(new ServiceScreenModel("Michael Johnson", R.drawable.pic_four));
        serviceScreenModels.add(new ServiceScreenModel("Kingston Prince", R.drawable.pic_five));
        serviceScreenModels.add(new ServiceScreenModel("Daniel Finn", R.drawable.pic_five));
        serviceScreenModels.add(new ServiceScreenModel("Gabriel Smith", R.drawable.pic_six));
        serviceScreenModels.add(new ServiceScreenModel("Prince David", R.drawable.pic_seven));
        serviceScreenModels.add(new ServiceScreenModel("Emma Page", R.drawable.pic_five));
        serviceScreenModels.add(new ServiceScreenModel("Bulter James", R.drawable.pic_four));
        serviceScreenModels.add(new ServiceScreenModel("Steph Andrews", R.drawable.pic_six));
        serviceScreenModels.add(new ServiceScreenModel("Andy Cole", R.drawable.pic_one));
        serviceScreenModels.add(new ServiceScreenModel("Seth Joel", R.drawable.pic_two));
        serviceScreenModels.add(new ServiceScreenModel("King Peter", R.drawable.pic_three));
        serviceScreenModels.add(new ServiceScreenModel("Jack Theodore", R.drawable.pic_four));
        serviceScreenModels.add(new ServiceScreenModel("Alvin Drew", R.drawable.pic_one));
        serviceScreenModels.add(new ServiceScreenModel("Samson Josh", R.drawable.pic_five));

        recyclerView.setAdapter(adapter);
//          allServiceTypeAdapterClick();
    }
    private void initListener() {
        arrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ServiceScreenActivity.this, ProductCategoryActivity.class);
                startActivity(myIntent);
            }
        });
    }
}