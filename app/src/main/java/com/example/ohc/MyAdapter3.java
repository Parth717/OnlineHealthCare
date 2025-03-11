package com.example.ohc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter3 extends RecyclerView.Adapter<MyAdapter3.MyViewHolder> {

    Context context;
    ArrayList<Medicine> list;

    public MyAdapter3(Context context, ArrayList<Medicine> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyAdapter3.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry3,parent,false);
        return new MyAdapter3.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter3.MyViewHolder holder,int position) {
        Medicine medicine=list.get(position);
        holder.name.setText(medicine.getName());
        holder.cost.setText(medicine.getCost());


    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,cost;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.textname);
            cost=itemView.findViewById(R.id.textcost);
        }
    }
}

