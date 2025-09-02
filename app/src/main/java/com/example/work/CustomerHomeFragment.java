package com.example.work;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class CustomerHomeFragment extends Fragment {
private View myView;

private LinearLayout searchBarLayout;
private Button seeAllButton;

    public CustomerHomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         myView =  inflater.inflate(R.layout.fragment_customer_home, container, false);

         initComponent();
         return myView;
    }

    private void initComponent() {
        initView();
        initListener();


    }

    private void initView() {
     searchBarLayout = myView.findViewById(R.id.search_service);
     seeAllButton  = myView.findViewById(R.id.btn_see_all);
    }

    private void initListener() {

        searchBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), ProductCategoryActivity.class);
                startActivity(myIntent);
            }
        });

        seeAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getActivity(), ProductCategoryActivity.class);
                startActivity(myIntent);
            }
        });
    }


}