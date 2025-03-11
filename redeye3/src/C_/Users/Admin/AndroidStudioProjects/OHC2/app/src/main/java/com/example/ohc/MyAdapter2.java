package com.example.ohc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewHolder> {

    Context context;
    ArrayList<LabTest> list;

    public MyAdapter2(Context context, ArrayList<LabTest> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyAdapter2.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry2,parent,false);
        return new MyAdapter2.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyViewHolder holder,int position) {
        LabTest labTest=list.get(position);
        holder.name.setText(labTest.getName());
        holder.cost.setText(labTest.getCost());


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
