package com.example.software_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MedicalTestReportView extends AppCompatActivity {
    EditText username;
    RecyclerView recyclerView;
    DatabaseReference database;
    PMedicalReportAdapter adapter;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    ArrayList<MedicalReportModel> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_test_report_view);
        try {
            database = FirebaseDatabase.getInstance().getReference("MedicalReport").child(mAuth.getCurrentUser().getUid());
            //  .child(Globals.sharedPreferences.getString("username", "user"));

            recyclerView = (RecyclerView) findViewById(R.id.medTestReport);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new PMedicalReportAdapter(this, list);
            recyclerView.setAdapter(adapter);
            database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        MedicalReportModel medReport = dataSnapshot.getValue(MedicalReportModel.class);
                        list.add(medReport);
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }catch (Exception e) {
            Log.e("ERROR__", e.getClass().getName() + ":" + e.getMessage());
        }
    }
}