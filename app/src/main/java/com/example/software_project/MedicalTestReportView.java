package com.example.software_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

    FirebaseAuth mAuth ;
    ArrayList<MedicalReportModel> list = new ArrayList<>();

    //My edit
    ArrayList<String> reportKeys = new ArrayList<>();
    //My edit*/







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_test_report_view);

        mAuth = FirebaseAuth.getInstance();
        try {
            database = FirebaseDatabase.getInstance().getReference("MedicalReport").child(mAuth.getCurrentUser().getUid());
            //  .child(Globals.sharedPreferences.getString("username", "user"));

            recyclerView = (RecyclerView) findViewById(R.id.medTestReport);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapter = new PMedicalReportAdapter(this, list);

            //My edit
            adapter.setReportKeys(reportKeys);

            adapter.setEditButtonClickListener(new PMedicalReportAdapter.EditButtonClickListener() {
                @Override
                public void onEditButtonClick(String key) {
                    // Handle the edit button click here
                    // You now have access to the key of the database record to update it
                    // Perform any actions you need based on the clicked edit button
                    Intent intent = new Intent(MedicalTestReportView.this, Update_Medical_report.class);
                    intent.putExtra("recordKey", key);
                    startActivity(intent);
                }
            });

            //My edit*/

            //My delete
            adapter.setDeleteButtonClickListener(new PMedicalReportAdapter.DeleteButtonClickListener() {
                @Override
                public void onDeleteButtonClick(int position) {
                    // Handle the delete button click event for the item at the given position
                    // Perform the deletion logic here, e.g., remove the item from the list and database
                    String reportKey = reportKeys.get(position);

                    // Remove the item from the database
                    database.child(reportKey).removeValue();

                    // Remove the item from the list
                    list.remove(position);

                    // Notify the adapter that the item has been removed
                    adapter.notifyItemRemoved(position);
                }
            });


            //My delete





            recyclerView.setAdapter(adapter);
            database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    //My delete
                    list.clear(); // Clear the list before adding new items
                    reportKeys.clear(); // Clear the reportKeys before adding new keys
                    //My delete


                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        MedicalReportModel medReport = dataSnapshot.getValue(MedicalReportModel.class);
                        list.add(medReport);
                        //My edit
                        reportKeys.add(dataSnapshot.getKey()); // Add the key to reportKeys
                        //My edit*/
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