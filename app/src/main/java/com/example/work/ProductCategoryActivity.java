package com.example.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.work.utility.ServiceModel;
import com.example.work.utility.ServicesAdapter;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private androidx.appcompat.widget.SearchView mySearchView;

    private ArrayList<ServiceModel> myServiceModel = new ArrayList<>();
    ServicesAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_category);

        initView();
        recyclerView();
        mySearchView();
        initListener();

    }
    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        mySearchView = findViewById(R.id.search_view);
    }
    private void recyclerView() {
            recyclerView.setHasFixedSize(false);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ProductCategoryActivity.this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);

            myAdapter = new ServicesAdapter(ProductCategoryActivity.this, myServiceModel);

            myServiceModel.add(new ServiceModel( "Appliances/Electronics"));
            myServiceModel.add(new ServiceModel( "AUTO-Mechanic/A.C/Rewire/Panel"));
            myServiceModel.add(new ServiceModel( "A.C / Refrigeration Services"));
            myServiceModel.add(new ServiceModel( "Barber"));
            myServiceModel.add(new ServiceModel( "Beautician"));
            myServiceModel.add(new ServiceModel( "Brick Layer / Tiller / POP"));
            myServiceModel.add(new ServiceModel( "Carpentry Services"));
            myServiceModel.add(new ServiceModel( "Catering Services"));
            myServiceModel.add(new ServiceModel( "Cleaning / Laundry / Fumigation"));
            myServiceModel.add(new ServiceModel( "Dispatch Rider"));
            myServiceModel.add(new ServiceModel( "Electrical / Inverter Services"));
            myServiceModel.add(new ServiceModel( "Generator Services"));
            myServiceModel.add(new ServiceModel( "Hair Stylist"));
            myServiceModel.add(new ServiceModel( "Home/Interior Fittings"));
            myServiceModel.add(new ServiceModel( "Painter /Screeder / Wallpaper"));
            myServiceModel.add(new ServiceModel( "Phone / Laptop"));
            myServiceModel.add(new ServiceModel( "Photographer / Video"));
            myServiceModel.add(new ServiceModel( "Plumbing Services"));
            myServiceModel.add(new ServiceModel( "Real Estate Realtor"));
            myServiceModel.add(new ServiceModel( "Vehicle Towing"));
            myServiceModel.add(new ServiceModel( "Welder Service"));

            recyclerView.setAdapter(myAdapter);
            adapterClickListener();
        }

    private void adapterClickListener() {
        myAdapter.setServiceTypeOnclickListener(new ServicesAdapter.OnClickListeners() {
            @Override
            public void handleServiceTypeClicked(int position, ServiceModel model) {
               Intent myIntent = new Intent(ProductCategoryActivity.this, ServiceScreenActivity.class);
               startActivity(myIntent);
            }
        });
    }


    private void mySearchView() {
        mySearchView.setOnQueryTextListener(new androidx.appcompat.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filterJobs(newText);
                return false;
            }

        });
    }

            private void filterJobs(String newText) {
                List<ServiceModel> myFilteredList = new ArrayList<>();
//        run a for loop to compare elements
                try {
                    for(ServiceModel items : myServiceModel){
                        if(items.getServices().toLowerCase().contains(newText.toLowerCase())){
                            myFilteredList.add(items);
                        }
                    }
                }
                catch (NullPointerException e){
                    Log.d("JobSeekerHomeFragment",  "exception is:" + e);
                }

                if(myFilteredList.isEmpty()){
//            dataContainer.setVisibility(View.GONE);
//            noResult.setVisibility(View.VISIBLE);
//            noData.setVisibility(View.GONE);
                }
                else{
//            dataContainer.setVisibility(View.VISIBLE);
//            noResult.setVisibility(View.GONE);
//            noData.setVisibility(View.GONE);
                    myAdapter.filterList(myFilteredList);
                }
            }


    private void initListener() {
    }





}