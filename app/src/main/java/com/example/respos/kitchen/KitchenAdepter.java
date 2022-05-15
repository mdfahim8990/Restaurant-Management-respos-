package com.example.respos.kitchen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.respos.ModelClass;
import com.example.respos.MyViewholder;
import com.example.respos.R;
import com.example.respos.RetrofitClient;

public class KitchenAdepter extends RecyclerView.Adapter<KitchenViewHolder> {

    Context context;
    Modelkitchen modelKitchen;

    public KitchenAdepter(Context context, Modelkitchen modelKitchen) {
        this.context = context;
        this.modelKitchen = modelKitchen;
    }

    @NonNull
    @Override
    public KitchenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.kitchen_oder_design, parent, false);
        KitchenViewHolder viewholder = new KitchenViewHolder(view);

        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull KitchenViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Datum data1 = modelKitchen.getData().get(position);
        holder.idk.setText(String.valueOf(data1.getId()));
        holder.locationk.setText(String.valueOf(data1.getId()));
        holder.amountk.setText(String.valueOf(data1.getId()));
        holder.delivery_timek.setText(String.valueOf(data1.getId()));
        holder.delivery_statusk.setText(String.valueOf(data1.getId()));


    }

    @Override
    public int getItemCount() {
        return modelKitchen.getData().size();
    }
}
