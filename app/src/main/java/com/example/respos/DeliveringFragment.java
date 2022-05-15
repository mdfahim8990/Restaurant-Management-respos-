package com.example.respos;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.respos.SqliteDataBase.DataBaseHelper;
import com.example.respos.kitchen.Modelkitchen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DeliveringFragment extends Fragment {
    RecyclerView recyclerView;
    private DataBaseHelper dataBaseHelper;
    ProgressBar progressBar;
    TextView textView;

    public DeliveringFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delivering, container, false);
        /*recyclerView = rootView.findViewById(R.id.recyclerview_kitchen);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));*/
        progressBar = rootView.findViewById(R.id.loadingDelivering);
        textView = rootView.findViewById(R.id.delivering);
        dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.fetchAllData();

        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        /*Call<ModelDelivering> call = methods.getOrderDelivering(dataBaseHelper.Api_key, dataBaseHelper.Api_secet);
        call.enqueue(new Callback<ModelDelivering>() {
            @Override
            public void onResponse(Call<ModelDelivering> call, Response<ModelDelivering> response) {
                Log.e(TAG, "Response Massage :" + response.body().message);
                ModelDelivering data = response.body();
                textView.setText(data.message);
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                }

                Toast.makeText(getActivity(), data.message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelDelivering> call, Throwable t) {

            }
        });*/
        return rootView;
    }
}