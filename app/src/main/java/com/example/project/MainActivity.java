package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPrefEdit;
    private EditText förnamn, efternamn;
    private String förnamnStr, efternamnStr;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        förnamn = findViewById(R.id.edit_förnamn);
        efternamn = findViewById(R.id.edit_efternamn);
        btn1 = findViewById(R.id.secondActivity_btn);
        btn2 = findViewById(R.id.save_button);
        sharedPreferences = getSharedPreferences("myPref",MODE_PRIVATE);
        sharedPrefEdit = sharedPreferences.edit();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);




            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                förnamnStr = förnamn.getText().toString();
                efternamnStr = efternamn.getText().toString();
                sharedPrefEdit.putString("förnamn", förnamnStr);
                sharedPrefEdit.putString("efternamn", efternamnStr);
                sharedPrefEdit.apply();

            }
        });


    }

}
