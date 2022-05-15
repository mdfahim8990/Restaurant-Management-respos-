package com.example.respos.kitchen;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.respos.R;

public class kitchen_Viewholdes extends RecyclerView.ViewHolder {
    TextView id , location,amount , delivery_time,delivery_status;
    public kitchen_Viewholdes(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id_k);
        location=itemView.findViewById(R.id.location_k);
        amount = itemView.findViewById(R.id.amount_k);
        delivery_time = itemView.findViewById(R.id.delivery_time_k);
        delivery_status = itemView.findViewById(R.id.delivery_status_k);
    }
}
