package com.akshay.nammacanteen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;

public class mainPage extends AppCompatActivity {




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentmanager = getSupportFragmentManager();
            FragmentTransaction transaction=fragmentmanager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content,new homeFragment()).commit();
                    return true;
                case R.id.navigation_status:
                    transaction.replace(R.id.content,new orderFragment().newInstance(null,null)).commit();
                    return true;
                case R.id.navigation_review:
                    transaction.replace(R.id.content,new userreviewFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.content,new userorderFragment()).commit();
                    return true;
                case R.id.navigation_profile:
                    transaction.replace(R.id.content,new profileFragment().newInstance(null,null)).commit();
                    return true;
            }
            return false;
        }

    };

    //Task to be performed on clicking Back Button
    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To make your app Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //To hide the input keyboard on opening a new Activity
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        setContentView(R.layout.activity_main_page);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentManager fragmentmanager = getSupportFragmentManager();
        FragmentTransaction transaction=fragmentmanager.beginTransaction();
        transaction.replace(R.id.content,new homeFragment()).commit();
    }

}
