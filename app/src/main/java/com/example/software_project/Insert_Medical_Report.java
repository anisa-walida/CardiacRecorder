package com.example.software_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Insert_Medical_Report extends AppCompatActivity {
    EditText name,date,Time,Systolic,Diastolic,Heartrate,comment;
    Button b1,b2, logout;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    /**
     * oncreate method created
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_insert_medical_report);
        name=findViewById(R.id.nill);
        date=findViewById(R.id.gastric);
        Time=findViewById(R.id.glucose);
        Systolic=findViewById(R.id.sodium);
        Diastolic=findViewById(R.id.sugar);
        Heartrate=findViewById(R.id.urin);
        comment=findViewById(R.id.henlo);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.next);
        logout = findViewById(R.id.logout_button);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("MedicalReport");
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Insert_Medical_Report.this, Login.class));
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override

                public void onClick(View v) {
                    insertPatientbill();
                }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Insert_Medical_Report.this, MedicalTestReportView.class);
                startActivity(intent);
            }
        });
    }
    private void insertPatientbill(){
        String Name=name.getText().toString();
        String DATE=date.getText().toString();
        String TIME=Time.getText().toString();
        String SYSTOLIC=Systolic.getText().toString();
        String DIASTOLIC=Diastolic.getText().toString();
        String HEARTRATE=Heartrate.getText().toString();
        String COMMENT=comment.getText().toString();

        MedicalReportModel medicalReportModel = new MedicalReportModel(
                Name,
                DATE,
                TIME,
                SYSTOLIC,
                DIASTOLIC,
                HEARTRATE,
                COMMENT

        );
        try {
            databaseReference.child(mAuth.getCurrentUser().getUid()).push().setValue(medicalReportModel);
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}