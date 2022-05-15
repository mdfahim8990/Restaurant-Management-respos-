package com.example.respos;

import static androidx.constraintlayout.helper.widget.MotionEffect.AUTO;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.respos.SqliteDataBase.Data;
import com.example.respos.SqliteDataBase.DataBaseHelper;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewOrderFragment extends Fragment {
    RecyclerView recyclerView;
    MyAdepter adepter;
    private DataBaseHelper dataBaseHelper;
    ProgressBar progressBar;


    public NewOrderFragment()
    {


      /*  Map<String, String> data = new HashMap<>();
        data.put("order_id", "1");
        data.put("kitchen_id", "VC56223CE4B59496");
        data.put("status", "3");
        Call<OderStatusUpdateModel> post = methods.postAllData("XBQFrK0VMQkJHejmuRAgFgg1O5qsiZU1YsUWXBx38ys", data);


        post.enqueue(new Callback<OderStatusUpdateModel>() {
            @Override
            public void onResponse(Call<OderStatusUpdateModel> call, Response<OderStatusUpdateModel> response) {
                OderStatusUpdateModel data1 = response.body();
                Log.e(TAG, "post : " + response.message());
            }

            @Override
            public void onFailure(Call<OderStatusUpdateModel> call, Throwable t) {
                Log.e(TAG, "post : " + t.getMessage());
            }
        });*/

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_new_order, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressBar=  rootView.findViewById(R.id.loadingPanel);

        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);

        Calendar calendar = Calendar.getInstance();
        String currentData = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(calendar.getTime( ));
        Log.e(TAG, "Current Time and Date : " + currentData);

        dataBaseHelper = new DataBaseHelper(getActivity());
//fahim
        dataBaseHelper.fetchAllData();
        Log.e("data_body", "Api__key: " +dataBaseHelper.Api_key);
        Log.e("data_body", "Api__key: " +dataBaseHelper.Api_secet);


        Call<ModelClass> call = methods.getAllData("7c222fb2927d828af22f592134e8932480637c0d","5e8667a439c68f5145dd2fcbecf02209");
        //Call<ModelClass> call = methods.getAllData(dataBaseHelper.Api_key,dataBaseHelper.Api_secet);
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                Log.e(TAG, "Response Code :" + response.code());
                ModelClass data = response.body();
                Log.e("data_body", "Body" + response.body().getData().size());


                ((MainActivity)getActivity()).CountNumber(data.getData().size());

                if (data.getStatus()) {
                    adepter = new MyAdepter(getActivity(), data);
                    recyclerView.setAdapter(adepter);
                    progressBar.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                Log.e("tag", t.getMessage());


            }
        });

        return rootView;
    }
}