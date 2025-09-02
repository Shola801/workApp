package com.example.work;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.KeyEventDispatcher;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class CustomerDashBoard extends AppCompatActivity {

    private View homeViewBlack, homeViewBlue;
    private TextView hometextView;
    
    private View announcementViewBlack, announcementViewBlue;
    private TextView announcementTextView;
    
    private View accountViewBlack, accountViewBlue;
    private TextView accountTextView;
    private RelativeLayout layoutHome, layoutAnnouncement, layoutAccount;

    private Toolbar myToolBar;
    private NavigationView myNavigationView;
    private DrawerLayout myDrawerLayout;
    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;
    private ActionBarDrawerToggle myDrawerToggle;
    private View headerView;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_dash_board);
        
        initView();
        navDrawer();
        initListener();
    }

    private void initView() {
        homeViewBlack = findViewById(R.id.view_home_black);
        homeViewBlue = findViewById(R.id.view_home_blue);
        hometextView = findViewById(R.id.tv_home);
        announcementViewBlack = findViewById(R.id.view_announcement_black);
        announcementViewBlue = findViewById(R.id.view_announcement_blue);
        announcementTextView = findViewById(R.id.tv_announcement);
        accountViewBlack = findViewById(R.id.view_profile_black);
        accountViewBlue = findViewById(R.id.view_profile_blue);
        accountTextView = findViewById(R.id.tv_account);
        layoutHome = findViewById(R.id.layout_home);
        layoutAnnouncement = findViewById(R.id.layout_announcement);
        layoutAccount = findViewById(R.id.layout_account);
        myToolBar = findViewById(R.id.tool_bar);
        myDrawerLayout = findViewById(R.id.drawer_layout);
        myNavigationView = findViewById(R.id.nav_view);
      
        startFragment();
    }
    private void navDrawer() {
        setSupportActionBar(myToolBar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        myDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, myToolBar, R.string.nav_open, R.string.nav_close);
        myDrawerToggle.syncState();
        myDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
//        drawerLayout.addDrawerListener(toggle);
        // Set the custom icon
//        myDrawerToggle.setHomeAsUpIndicator(R.drawable.menu_drawer);
//        myDrawerToggle.setDrawerIndicatorEnabled(false); // D
        myDrawerLayout.addDrawerListener(myDrawerToggle);
        myNavigationView.bringToFront();

        headerView();
    }

    @SuppressLint("SetTextI18n")
    private void headerView() {
        headerView = myNavigationView.getHeaderView(0);
        navInitView();
        navInItListener();
    }

    @SuppressLint("SetTextI18n")
    private void navInitView() {

//        profile = headerView.findViewById(R.id.tv_profile);
//        changePin = headerView.findViewById(R.id.tv_change_pin);
//        bankDetails = headerView.findViewById(R.id.tv_bank_details);
//        help = headerView.findViewById(R.id.tv_help);
//        settings = headerView.findViewById(R.id.tv_settings);
//        enrolledCourses = headerView.findViewById(R.id.tv_enrolled_courses);
//        logOut = headerView.findViewById(R.id.tv_log_out);
//        enrolledCourses.setVisibility(View.GONE);
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void navInItListener() {
//        profile.setOnClickListener(view -> {
//            Tools.navigateToPage(MarketerDashboardActivity.this, MarketerProfileActivity.class);
//            getViewBinding().drawerLayout.closeDrawer(GravityCompat.START);
//
//        });
//
//        changePin.setOnClickListener(view -> {
//            Tools.navigateToPage(MarketerDashboardActivity.this, MarketerChangePinActivity.class);
//            getViewBinding().drawerLayout.closeDrawer(GravityCompat.START);
//        });
//
//        bankDetails.setOnClickListener(view -> {
//            Tools.navigateToPage(MarketerDashboardActivity.this, AddMarketerBankDetailsActivity.class);
//            getViewBinding().drawerLayout.closeDrawer(GravityCompat.START);
//        });
//
//        help.setOnClickListener(view -> {
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse(url));
//            intent.resolveActivity(getPackageManager());
//            startActivity(intent);
//
//            getViewBinding().drawerLayout.closeDrawer(GravityCompat.START);
//        });
//
//        settings.setOnClickListener(view -> {
//            Tools.navigateToPage(MarketerDashboardActivity.this, MarketerSettingsActivity.class);
//            getViewBinding().drawerLayout.closeDrawer(GravityCompat.START);
//        });
//
//        logOut.setOnClickListener(view -> {
//            Dialogs.logOutDialog(MarketerDashboardActivity.this);
//            getViewBinding().drawerLayout.closeDrawer(GravityCompat.START);
//        });
    }
    private void startFragment() {
        myFragmentManager = getSupportFragmentManager();
        myFragmentTransaction = myFragmentManager.beginTransaction();
        CustomerHomeFragment myCustomerHomeFragment  = new CustomerHomeFragment();
        myFragmentTransaction.add(R.id.fragment_container, myCustomerHomeFragment).commit();
    }

    private void initListener() {
        homeLayout();
        announcementLayout();
        profileLayout();
    }
    private void homeLayout() {
        layoutHome.setOnClickListener(view -> {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                homeViewBlack.setVisibility(View.VISIBLE);
                homeViewBlue.setVisibility(View.INVISIBLE);
                hometextView.setTextColor(getColor(R.color.black));

                announcementViewBlack.setVisibility(View.INVISIBLE);
                announcementViewBlue.setVisibility(View.VISIBLE);
                announcementTextView.setTextColor(getColor(R.color.black));

                accountViewBlack.setVisibility(View.INVISIBLE);
                accountViewBlue.setVisibility(View.VISIBLE);
                accountTextView.setTextColor(getColor(R.color.black));

                myFragmentManager = getSupportFragmentManager();
                myFragmentTransaction = myFragmentManager.beginTransaction();
                CustomerHomeFragment myCustomerHomeFragment  = new CustomerHomeFragment();
                myFragmentTransaction.replace(R.id.fragment_container, myCustomerHomeFragment).commit();

            }
        });
    }
    private void announcementLayout() {
        layoutAnnouncement.setOnClickListener(view -> {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                announcementViewBlack.setVisibility(View.VISIBLE);
                announcementViewBlue.setVisibility(View.INVISIBLE);
                announcementTextView.setTextColor(getColor(R.color.black));

                homeViewBlack.setVisibility(View.INVISIBLE);
                homeViewBlue.setVisibility(View.VISIBLE);
                hometextView.setTextColor(getColor(R.color.black));

                accountViewBlack.setVisibility(View.INVISIBLE);
                accountViewBlue.setVisibility(View.VISIBLE);
                accountTextView.setTextColor(getColor(R.color.black));

                myFragmentManager = getSupportFragmentManager();
                myFragmentTransaction = myFragmentManager.beginTransaction();
                CustomerAnnouncementFragment myCustomerAnnouncementFragment  = new CustomerAnnouncementFragment();
                myFragmentTransaction.replace(R.id.fragment_container, myCustomerAnnouncementFragment).commit();

            }
        });
    }
    private void profileLayout() {
        layoutAccount.setOnClickListener(view -> {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                accountViewBlack.setVisibility(View.VISIBLE);
                accountViewBlue.setVisibility(View.INVISIBLE);
                accountTextView.setTextColor(getColor(R.color.blue));

                homeViewBlack.setVisibility(View.INVISIBLE);
                homeViewBlue.setVisibility(View.VISIBLE);
                hometextView.setTextColor(getColor(R.color.blue));
                announcementViewBlack.setVisibility(View.INVISIBLE);
                announcementViewBlue.setVisibility(View.VISIBLE);
                announcementTextView.setTextColor(getColor(R.color.black));

                myFragmentManager = getSupportFragmentManager();
                myFragmentTransaction = myFragmentManager.beginTransaction();
                CustomerAccountFragment myCustomerProfileFragment  = new CustomerAccountFragment();
                myFragmentTransaction.replace(R.id.fragment_container, myCustomerProfileFragment).commit();

            }
        });
    }

}

