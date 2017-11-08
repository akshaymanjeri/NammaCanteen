package com.akshay.nammacanteen;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.DialogInterface.*;

public class homeActivity extends AppCompatActivity {

    Button b2;
    TextView t1;
    EditText Phoneno,Password;

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

        setContentView(R.layout.activity_home);
        if (isOnline()) {
            Phoneno = (EditText) findViewById(R.id.etUsername);
            Password = (EditText) findViewById(R.id.etPassword);
            t1 = (TextView) findViewById(R.id.tAdmin);
            t1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(homeActivity.this, adminLogin.class);
                    startActivity(intent);
                }

            });

            b2 = (Button) findViewById(R.id.bRegister);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(homeActivity.this, Registration.class);
                    startActivity(intent);
                }
            });
        } else {
            try
                {
                    //Display alert when internet is unavailable
                    AlertDialog.Builder builder =new AlertDialog.Builder(this);
                    builder.setTitle("No internet Connection");
                    builder.setMessage("Please turn on internet connection to continue");
                    builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }

            catch(Exception e)
            {

            }
        }
    }

    //Method invoked on clicking the Login Button during User Login
        public void Login(View view) {
            String username = Phoneno.getText().toString();
            String password = Password.getText().toString();
            String type = "login";
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type,username,password);
        }

    //Method to check if phone is connected to internet
    public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();

        if(netInfo == null || !netInfo.isConnected() || !netInfo.isAvailable()){
            return false;
        }
        return true;
    }
}