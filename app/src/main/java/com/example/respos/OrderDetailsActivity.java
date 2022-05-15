package com.example.respos;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.respos.OderDetailsAPIs.Data;
import com.example.respos.OderDetailsAPIs.OrderDetailsModelClass;
import com.example.respos.SqliteDataBase.DataBaseHelper;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OrderDetailsActivity extends AppCompatActivity {
    Context context;
    private Toolbar toolbar;
    Spinner spinnerAccept;
    Spinner spinnerReject;
    ArrayAdapter<CharSequence> adapterA;
    ArrayAdapter<CharSequence> adapterR;
    TextView PaymentStatus, OrderPlaced, OrderAccepted;
    private DataBaseHelper dataBaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        toolbar = findViewById(R.id.toolbardetails);
        setSupportActionBar(toolbar);
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        actionBar.setTitle("Order Detail's ");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        spinnerAccept = (Spinner) findViewById(R.id.spinnerAccept);
        spinnerReject = (Spinner) findViewById(R.id.spinnerReject);
        adapterA = ArrayAdapter.createFromResource(this, R.array.namesAccept, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAccept.setAdapter(adapterA);

        adapterR = ArrayAdapter.createFromResource(this, R.array.namesReject, android.R.layout.simple_spinner_item);
        adapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReject.setAdapter(adapterR);

        String Id = getIntent().getStringExtra("ID");

        spinnerAccept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {

                    AlertDialog dialog = new AlertDialog.Builder(OrderDetailsActivity.this)
                            .setTitle("Are You Sure !")
                            .setMessage("You Want to Print this Order")
                            .setPositiveButton("Yes", null)
                            .setNegativeButton("No", null)
                            .show();

                    Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                    positiveButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //fahim
                            Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
                            Map<String, String> data = new HashMap<>();
                            data.put("order_id", Id);
                            data.put("kitchen_id", "VC56223CE4B59496");
                            data.put("status", Integer.toString(position));
                            Call<OderStatusUpdateModel> post = methods.postAllData("7c222fb2927d828af22f592134e8932480637c0d","5e8667a439c68f5145dd2fcbecf02209", data);
                            post.enqueue(new Callback<OderStatusUpdateModel>() {
                                @Override
                                public void onResponse(Call<OderStatusUpdateModel> call, Response<OderStatusUpdateModel> response) {
                                    OderStatusUpdateModel data1 = response.body();
                                    Log.e(TAG, "post : " + data1.getMessage());
                                    Log.e(TAG, "post : " + data1.getStatus());
                                    Toast.makeText(getApplicationContext(), data1.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                @Override
                                public void onFailure(Call<OderStatusUpdateModel> call, Throwable t) {
                                    //Log.e(TAG, "post : " + t.getMessage());
                                }
                            });
                            Toast.makeText(getApplicationContext(), "Printing", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "position : " +position);
                            dialog.dismiss();

                        }
                    });

                    negativeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Cancel", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerReject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position != 0) {

                    AlertDialog dialog = new AlertDialog.Builder(OrderDetailsActivity.this)
                            .setTitle("Are You Sure !")
                            .setPositiveButton("Yes", null)
                            .setNegativeButton("No", null)
                            .show();

                    Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                    positiveButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Rejected", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();

                        }
                    });

                    negativeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        PaymentStatus = findViewById(R.id.paymentStatus);
        OrderPlaced = findViewById(R.id.OrderPlaced);
        OrderAccepted = findViewById(R.id.OrderAccepted);


        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.fetchAllData();
        Log.e("key", "Fahim: " +dataBaseHelper.Api_key);
        Log.e("secet", "Api__key: " +dataBaseHelper.Api_secet);

        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
       // Call<OrderDetailsModelClass> callPaymentDetails = methods.getOrderDetailsData("XBQFrK0VMQkJHejmuRAgFgg1O5qsiZU1YsUWXBx38ys");
        Call<OrderDetailsModelClass> callPaymentDetails = methods.getOrderDetailsData(dataBaseHelper.Api_key);

        callPaymentDetails.enqueue(new Callback<OrderDetailsModelClass>() {
            @Override
            public void onResponse(Call<OrderDetailsModelClass> call, Response<OrderDetailsModelClass> response) {
                Log.e(TAG, "Response Massage :" + response.body().data.itemList.size());
                Data data = response.body().data;
                PaymentStatus.setText(data.paymentStatus);
                OrderPlaced.setText(data.createdAt);
                OrderAccepted.setText(data.updatedAt);
            }

            @Override
            public void onFailure(Call<OrderDetailsModelClass> call, Throwable t) {

            }
        });
    }
}