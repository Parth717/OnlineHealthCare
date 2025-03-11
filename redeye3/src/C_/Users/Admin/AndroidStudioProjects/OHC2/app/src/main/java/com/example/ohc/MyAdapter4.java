package com.example.ohc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter4 extends RecyclerView.Adapter<MyAdapter4.MyViewHolder> {

    Context context;
    ArrayList<Details> list;

    public MyAdapter4(Context context, ArrayList<Details> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyAdapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.userentry_4,parent,false);
        return new MyAdapter4.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter4.MyViewHolder holder,int position) {
        Details details=list.get(position);

        holder.date.setText(details.getDate());

        holder.name.setText(details.getName());
        holder.age.setText(details.getAge());
        holder.dob.setText(details.getDob());
        holder.weight.setText(details.getWeight());
        holder.height.setText(details.getHeight());
        holder.temp.setText(details.getTemp());
        holder.pulse.setText(details.getPulse());
        holder.spo.setText(details.getSpo());
        holder.bp.setText(details.getBp());
        holder.sugar.setText(details.getSugar());

    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView  date,name,age,dob,weight,height,temp,pulse,spo,bp,sugar;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.textdate);

            name=itemView.findViewById(R.id.textname);
            age=itemView.findViewById(R.id.textage);
            dob=itemView.findViewById(R.id.textdob);
            weight=itemView.findViewById(R.id.textweight);
            height=itemView.findViewById(R.id.textheight);
            temp=itemView.findViewById(R.id.texttemp);
            pulse=itemView.findViewById(R.id.textpulse);
            spo=itemView.findViewById(R.id.textspo);
            bp=itemView.findViewById(R.id.textbp);
            sugar=itemView.findViewById(R.id.textsugar);


        }
    }
}
