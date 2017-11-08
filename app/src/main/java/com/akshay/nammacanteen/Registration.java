package com.akshay.nammacanteen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
    EditText Phoneno,Username,Password,Houseno,Street,City;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //To make your app Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //To hide the input keyboard on opening a new Activity
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        setContentView(R.layout.activity_registration);
        Phoneno= (EditText) findViewById(R.id.phno);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.pswd);
        Houseno=(EditText) findViewById(R.id.hno);
        Street=(EditText) findViewById(R.id.street);
        City=(EditText) findViewById(R.id.city);
    }

    //Method invoked when Submit Button is clicked in Registration Activity
    public void Submit(View view){
        String phoneno = Phoneno.getText().toString();
        String username = Username.getText().toString();
        String password = Password.getText().toString();
        String houseno = Houseno.getText().toString();
        String street = Street.getText().toString();
        String city = City.getText().toString();
        String type="submit";
        BackgroundWorker backgroundworker = new BackgroundWorker(this);
        backgroundworker.execute(type,phoneno,username,password,houseno,street,city);
    }
    }

