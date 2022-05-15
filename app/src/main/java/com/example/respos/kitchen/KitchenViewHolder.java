package com.example.respos.kitchen;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.respos.R;

public class KitchenViewHolder extends RecyclerView.ViewHolder {
    TextView idk , locationk,amountk , delivery_timek,delivery_statusk;


    public KitchenViewHolder(@NonNull View itemView) {
        super(itemView);
        idk = itemView.findViewById(R.id.id_k);
        locationk=itemView.findViewById(R.id.location_k);
        amountk = itemView.findViewById(R.id.amount_k);
        delivery_timek = itemView.findViewById(R.id.delivery_time_k);
        delivery_statusk = itemView.findViewById(R.id.delivery_status_k);
    }
}
