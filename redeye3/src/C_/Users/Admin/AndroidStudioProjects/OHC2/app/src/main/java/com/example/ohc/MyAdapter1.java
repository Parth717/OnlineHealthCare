package com.example.ohc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class MyAdapter1 extends RecyclerView.Adapter<MyAdapter1.MyViewHolder> {

    Context context;
    ArrayList<Appointment> list;

    public MyAdapter1(Context context, ArrayList<Appointment> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter1.MyViewHolder holder,int position) {
        Appointment appointment=list.get(position);
        holder.title.setText(appointment.getTitle());
        holder.fullname.setText(appointment.getFullname());
        holder.address.setText(appointment.getAddress());
        holder.contact.setText(appointment.getContact());
        holder.fees.setText(appointment.getFees());
        holder.date.setText(appointment.getDate());
        holder.time.setText(appointment.getTime());

    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,fullname,address,contact,fees,date,time;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.texttitle);
            fullname=itemView.findViewById(R.id.textname);
            address=itemView.findViewById(R.id.textadd);
            contact=itemView.findViewById(R.id.textcontact);
            fees=itemView.findViewById(R.id.textfee);
            date=itemView.findViewById(R.id.textdate);
            time=itemView.findViewById(R.id.texttime);


        }
    }
}
