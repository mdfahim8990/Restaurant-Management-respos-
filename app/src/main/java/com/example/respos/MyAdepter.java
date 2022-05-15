package com.example.respos;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAdepter extends RecyclerView.Adapter<MyViewholder> {

    Context context;
    ModelClass modelData;
    OderStatusUpdateModel oderStatusUpdateModel;

    public MyAdepter(Context context, ModelClass modelData) {
        this.context = context;
        this.modelData = modelData;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.oder_design, parent, false);
        MyViewholder viewholder = new MyViewholder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, @SuppressLint("RecyclerView") int position) {

        //Double.valueOf()
        Datum data = modelData.getData().get(position);
        /*String check=data.getAddress().toString() ;*/
        holder.id.setText(String.valueOf(data.getId()));
        if (data.getAddress()==null){
            holder.location.setText("Not Found");
        }else {
            holder.location.setText(String.valueOf(data.getAddress()));
        }

        holder.amount.setText(String.valueOf(data.getOrderTotal()));
        if (data.getDeliveryCharge() == null) {
            holder.delivery_time.setText("0");
        } else {
            holder.delivery_time.setText(String.valueOf(data.getDeliveryCharge()));
        }
        holder.delivery_status.setText("New");


        Log.e(TAG, "order Total : " + data.getDriverId());

        holder.delivery_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, OrderDetailsActivity.class);
                intent.putExtra("ID",String.valueOf(data.getId()));
                context.startActivity(intent);
                //Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return modelData.getData().size();
    }


}