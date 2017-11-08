package com.akshay.nammacanteen;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class adminLogin extends AppCompatActivity {

    EditText Phoneno,Password;

    //Task to be performed on clicking Back Button
    @Override
    public void onBackPressed(){
        Intent i=new Intent(this,homeActivity.class);
        this.startActivity(i);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To make your app Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //To hide the input keyboard on opening a new Activity
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        setContentView(R.layout.activity_admin_login);
        Phoneno=(EditText)findViewById(R.id.etUsername);
        Password=(EditText)findViewById((R.id.etPassword));

    }

    //Method invoked on clicking the Login Button during Admin Login
    public void Login1(View view){
        String username = Phoneno.getText().toString();
        String password = Password.getText().toString();
        String type = "admin";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,username,password);
    }
}
