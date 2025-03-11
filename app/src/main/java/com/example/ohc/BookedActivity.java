package com.example.ohc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookedActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    ArrayList<Appointment> list;
    MyAdapter1 myAdpter;
    FirebaseAuth mAuth;
    FirebaseUser user;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked);

        recyclerView = findViewById(R.id.recycler1);
        database= FirebaseDatabase.getInstance().getReference("Appointment");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();

        list =new ArrayList<>();
        myAdpter =new MyAdapter1(this,list);
        recyclerView.setAdapter(myAdpter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot datasnapshot:snapshot.child(user.getUid()).getChildren()) {
                    Appointment appointment=datasnapshot.getValue(Appointment.class);
                    list.add(appointment);
                }
                myAdpter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}