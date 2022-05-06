package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView firstname, lastname;
    private String firstNameStr, lastNameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);




    }
    public void onResume(){
        super.onResume();
        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        SharedPreferences mySharedPref = getSharedPreferences("myPref", MODE_PRIVATE);

        firstNameStr = mySharedPref.getString("förnamn", "");
        lastNameStr = mySharedPref.getString("efternamn", "");

        firstname.setText(firstNameStr);
        lastname.setText(lastNameStr);


    }



}