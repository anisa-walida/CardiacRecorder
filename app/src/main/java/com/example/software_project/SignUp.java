package com.example.software_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    EditText signupName, signupUsername, signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private void createAccount(String email, String password, SignUp context){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(context , "Created an user", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    Toast.makeText(context , "Not created an user" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }
    private void updateUI(FirebaseUser user){
        if (user==null)
            startActivity(new Intent(SignUp.this, Login.class));
        else
            startActivity(new Intent(SignUp.this, Insert_Medical_Report.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_sign_up);
        signupName = findViewById(R.id.name);
        signupEmail = findViewById(R.id.email);
        signupUsername = findViewById(R.id.username);
        signupPassword = findViewById(R.id.password);
        loginRedirectText = findViewById(R.id.textv);
        signupButton = findViewById(R.id.button3);
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                if (name.isEmpty()){
                    signupName.setError("Name cannot be empty");
                    return;
                }
                if (email.isEmpty()){
                    signupEmail.setError("Email cannot be empty");
                    return;
                }
                if (username.isEmpty()){
                    signupUsername.setError("Name cannot be empty");
                    return;
                }
                if (password.isEmpty()){
                    signupPassword.setError("Password cannot be empty");
                    return;
                }
                createAccount(email, password, SignUp.this);

                HelperClass helperClass = new HelperClass(name, email, username, password);
                try {
                    reference.child(username).setValue(helperClass);
                    Toast.makeText(SignUp.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, Login.class);
                    startActivity(intent);
                }catch (NullPointerException ex){
                    ex.printStackTrace();
                }

            }
        });
        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }
}