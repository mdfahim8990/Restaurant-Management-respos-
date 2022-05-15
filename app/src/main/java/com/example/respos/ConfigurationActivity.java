package com.example.respos;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.respos.SqliteDataBase.Data;
import com.example.respos.SqliteDataBase.DataBaseHelper;

import java.io.IOException;

public class ConfigurationActivity extends AppCompatActivity {

    /*ImageButton imageButton;*/
    private static final int SELECT_PHOTO = 100;

    EditText R_name, P_number, A_key, A_secret, K_id, A_endpoint, Address;
    Button Submit;
    private DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        dataBaseHelper = new DataBaseHelper(getApplicationContext());


        /*imageButton = findViewById(R.id.image_picker);*/
        R_name = findViewById(R.id.Rname);
        P_number = findViewById(R.id.pnumber);
        A_key = findViewById(R.id.akey);
        A_secret = findViewById(R.id.asecret);
        K_id = findViewById(R.id.kid);
        A_endpoint = findViewById(R.id.aendpoint);
        Address = findViewById(R.id.address);
        Submit = findViewById(R.id.sub_button);


        dataBaseHelper.fetchAllData();

        R_name.setText(dataBaseHelper.Restaurant_name);
        P_number.setText(dataBaseHelper.Phone_number);
        A_key.setText(dataBaseHelper.Api_key);
        A_secret.setText(dataBaseHelper.Api_secet);
        K_id.setText(dataBaseHelper.Kitchen_id);
        A_endpoint.setText(dataBaseHelper.Api_endpoint);
        Address.setText(dataBaseHelper.Address);
        Log.e(TAG,"id :  " +dataBaseHelper.Id);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //For Fetching data from database
                dataBaseHelper.fetchAllData();
                String getR_name = R_name.getText().toString();
                String getP_number = P_number.getText().toString();
                String getA_key = A_key.getText().toString();
                String getA_secret = A_secret.getText().toString();
                String getK_id = K_id.getText().toString();
                String getA_endpoint = A_endpoint.getText().toString();
                String getAddress = Address.getText().toString();
                if (getR_name.isEmpty()){
                    R_name.setError("Insert Restaurant Name");
                    return;

                }else if (getP_number.isEmpty()){
                    P_number.setError("Insert Phone Number");
                    return;

                }else if (getA_key.isEmpty()) {
                    A_key.setError("Insert Api key");
                    return;
                }else if (getA_secret.isEmpty()) {
                    A_secret.setError("Insert Api Secret");
                    return;
                }else if (getK_id.isEmpty()) {
                    K_id.setError("Insert Kitchen Id");
                    return;
                }else if (getA_endpoint.isEmpty()) {
                    A_endpoint.setError("Insert Api Endpoint");
                    return;
                }else if (getAddress.isEmpty()) {
                    Address.setError("Insert Address");
                    return;
                }else {

                   if (dataBaseHelper.Id == null){
                       dataBaseHelper.insertData(new Data(getR_name, getP_number, getA_key,
                               getA_secret, getK_id, getA_endpoint, getAddress));
                       Toast.makeText(ConfigurationActivity.this,"Data Inserted",Toast.LENGTH_SHORT).show();

                   }else {
                       //For Update data from database
                       dataBaseHelper.UpdateData(new Data(getR_name, getP_number, getA_key,
                               getA_secret, getK_id, getA_endpoint, getAddress), dataBaseHelper.Id);
                       Toast.makeText(ConfigurationActivity.this,"Data Updated",Toast.LENGTH_SHORT).show();
                   }


                }
                //For delete Data from database
               /* dataBaseHelper.deleteData(new Data(getR_name, getP_number, getA_key,
                        getA_secret, getK_id, getA_endpoint, null));*/
            }


        });


    }
}