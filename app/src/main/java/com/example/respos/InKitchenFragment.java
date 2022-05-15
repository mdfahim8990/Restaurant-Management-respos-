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

import com.example.respos.kitchen.Kitchen_Adepter;
import com.example.respos.kitchen.Modelkitchen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InKitchenFragment extends Fragment {
    RecyclerView recyclerView;
    Kitchen_Adepter Kitchen_Adepter;
    ProgressBar progressBar;
    public InKitchenFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_in_kitchen, container, false);
        progressBar = rootView.findViewById(R.id.loadingKitchen);
        recyclerView = rootView.findViewById(R.id.recyclerview_kitchen);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        Call<Modelkitchen> call = methods.getOrderINKitchen("7c222fb2927d828af22f592134e8932480637c0d","5e8667a439c68f5145dd2fcbecf02209");
        call.enqueue(new Callback<Modelkitchen>() {
            @Override
            public void onResponse(Call<Modelkitchen> call, Response<Modelkitchen> response) {
                Log.e(TAG, "Response Code :" + response.code());
                Modelkitchen data = response.body();
                Log.e("data_body", "Body" + response.body().getData().size());

                ((MainActivity)getActivity()).CountNumberkitchen(data.getData().size());

                if (data.getStatus()) {
                    Kitchen_Adepter = new Kitchen_Adepter(getActivity(), data);
                    recyclerView.setAdapter(Kitchen_Adepter);
                    progressBar.setVisibility(View.GONE);

                }

            }

            @Override
            public void onFailure(Call<Modelkitchen> call, Throwable t) {

            }

        });



        return rootView;
    }
}