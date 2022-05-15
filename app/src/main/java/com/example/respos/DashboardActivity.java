package com.example.respos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.respos.SqliteDataBase.DataBaseHelper;

import java.text.CollationElementIterator;

public class DashboardActivity extends AppCompatActivity {

    Button OrderPad,Configuration ;
    private DataBaseHelper dataBaseHelpe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        dataBaseHelpe = new DataBaseHelper(getApplicationContext());



        OrderPad = findViewById(R.id.ordered_pad_button);
        Configuration = findViewById(R.id.config_button);

        OrderPad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Configuration.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                //R_name.setText(dataBaseHelpe.Restaurant_name);


                Intent intent = new Intent(DashboardActivity.this,ConfigurationActivity.class);
                startActivity(intent);
            }
        });

    }
}