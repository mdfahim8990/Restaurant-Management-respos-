package com.example.respos;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;




public class MyViewholder extends RecyclerView.ViewHolder {
    TextView id , location,amount , delivery_time,delivery_status;

    public MyViewholder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.id);
        location=itemView.findViewById(R.id.location);
        amount = itemView.findViewById(R.id.amount);
        delivery_time = itemView.findViewById(R.id.delivery_time);
        delivery_status = itemView.findViewById(R.id.delivery_status);


    }
}
