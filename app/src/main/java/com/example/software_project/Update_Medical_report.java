package com.example.software_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class Update_Medical_report extends AppCompatActivity {
    EditText name, date, Time, Systolic, Diastolic, Heartrate, comment;
    Button b1, b2, logout;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    String recordKey; // Variable to store the key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.p_medical_report_edit_delete);
        name = findViewById(R.id.nille);
        date = findViewById(R.id.gastrice);
        Time = findViewById(R.id.glucosee);
        Systolic = findViewById(R.id.sodiume);
        Diastolic = findViewById(R.id.sugare);
        Heartrate = findViewById(R.id.urine);
        comment = findViewById(R.id.henloe);
        b1 = findViewById(R.id.ebutton);
        b2 = findViewById(R.id.nexte);
        logout = findViewById(R.id.logout_buttone);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("MedicalReport");
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Update_Medical_report.this, Login.class));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                updateReport();
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Update_Medical_report.this, MedicalTestReportView.class);
                startActivity(intent);
            }
        });

        // Retrieve the key from the intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            recordKey = extras.getString("recordKey");
        }

    }
    public void updateReport(){
        String updatedName = name.getText().toString();
        String updatedDate = date.getText().toString();
        String updatedTime = Time.getText().toString();
        String updatedSystolic = Systolic.getText().toString();
        String updatedDiastolic = Diastolic.getText().toString();
        String updatedHeartRate = Heartrate.getText().toString();
        String updatedComment = comment.getText().toString();

        Map<String, Object> updatedData = new HashMap<>();
        updatedData.put("name", updatedName);
        updatedData.put("date", updatedDate);
        updatedData.put("time", updatedTime);
        updatedData.put("systolic", updatedSystolic);
        updatedData.put("diastolic", updatedDiastolic);
        updatedData.put("heartRate", updatedHeartRate);
        updatedData.put("comment", updatedComment);

        try {
            DatabaseReference childRef = databaseReference.child(mAuth.getCurrentUser().getUid()).child(recordKey);
            childRef.updateChildren(updatedData);
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
