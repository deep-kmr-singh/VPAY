package com.example.vpay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<com.example.vpay.myadapter.myviewholder>
{
  ArrayList<com.example.vpay.model> dataholder;

    public myadapter(ArrayList<com.example.vpay.model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {
        holder.card_no.setText(dataholder.get(position).getCard_no());
        holder.expiry_month.setText(dataholder.get(position).getExpiry_month());
        holder.expiry_year.setText(dataholder.get(position).getExpiry_year());
        holder.cvv_no.setText(dataholder.get(position).getCvv_no());
        holder.amount.setText(dataholder.get(position).getAmount());
        holder.customer_name.setText(dataholder.get(position).getCustomer_name());
        holder.mobile_no.setText(dataholder.get(position).getMobile_no());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView card_no, expiry_month, expiry_year, cvv_no, amount, customer_name, mobile_no;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            card_no = (TextView)itemView.findViewById(R.id.display_card_no);
            expiry_month = (TextView)itemView.findViewById(R.id.display_expiry_month);
            expiry_year = (TextView)itemView.findViewById(R.id.display_expiry_year);
            cvv_no = (TextView)itemView.findViewById(R.id.display_cvv_no);
            amount = (TextView)itemView.findViewById(R.id.display_amount);
            customer_name = (TextView)itemView.findViewById(R.id.display_customer_name);
            mobile_no = (TextView)itemView.findViewById(R.id.display_mobile_no);
        }
    }

}
