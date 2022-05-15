package com.example.respos;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.respos.SqliteDataBase.DataBaseHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DeliveredFragment extends Fragment {
    private DataBaseHelper dataBaseHelper;
    ProgressBar progressBar;
    TextView textView;

    public DeliveredFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delivered, container, false);
        progressBar = rootView.findViewById(R.id.loadingDelivered);
        textView = rootView.findViewById(R.id.delivered);
        dataBaseHelper = new DataBaseHelper(getActivity());
        dataBaseHelper.fetchAllData();

        Methods methods = RetrofitClient.getRetrofitInstance().create(Methods.class);
        /*Call<ModelDelivered> call = methods.getOrderDelivered(dataBaseHelper.Api_key, dataBaseHelper.Api_secet);
        call.enqueue(new Callback<ModelDelivered>() {
            @Override
            public void onResponse(Call<ModelDelivered> call, Response<ModelDelivered> response) {
                Log.e(TAG, "Response Massage :" + response.body().message);
                ModelDelivered data = response.body();
                textView.setText(data.message);
                if (response.isSuccessful()) {
                    progressBar.setVisibility(View.GONE);
                }

                Toast.makeText(getActivity(), data.message, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ModelDelivered> call, Throwable t) {

            }
        });*/


        return rootView;
    }
}