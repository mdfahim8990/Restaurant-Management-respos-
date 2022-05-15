package com.example.respos.kitchen;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.respos.ModelClass;
import com.example.respos.MyViewholder;
import com.example.respos.OrderDetailsActivity;
import com.example.respos.R;

public class Kitchen_Adepter extends RecyclerView.Adapter<kitchen_Viewholdes> {
    Context context;
    Modelkitchen modelkitchen;

    public Kitchen_Adepter(Context context, Modelkitchen modelkitchen) {
        this.context = context;
        this.modelkitchen = modelkitchen;
    }
    @NonNull
    @Override
    public kitchen_Viewholdes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kitchen_oder_design, parent, false);
        kitchen_Viewholdes viewholder = new kitchen_Viewholdes(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull kitchen_Viewholdes holder, int position) {

        Datum data = modelkitchen.getData().get(position);
        /*String check=data.getAddress().toString() ;*/
        holder.id.setText(String.valueOf(data.getId()));
        holder.location.setText(String.valueOf(data.getLocationId()));
        holder.amount.setText(String.valueOf(data.getOrderTotal()));
        if (data.getDeliveryIn() == null) {
            holder.delivery_time.setText("0");
        } else {
            holder.delivery_time.setText(String.valueOf(data.getDeliveryIn()));
        }
        holder.delivery_status.setText("New");


        Log.e(TAG, "order Total : " + data.getDeliveryIn());

        holder.delivery_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent intent = new Intent(context, OrderDetailsActivity.class);
                context.startActivity(intent);*/
                //Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelkitchen.getData().size();
    }
}
