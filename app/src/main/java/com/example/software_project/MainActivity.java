package com.example.software_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    private static int SPLASH_SCREEN=2500;
    Animation topanim,bottomanim;
    ImageView image;
    TextView logoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.bottomanim);

        image=findViewById(R.id.imageView);
        logoi=findViewById(R.id.textView2);

        image.setAnimation(topanim);
        logoi.setAnimation(bottomanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser user = mAuth.getCurrentUser();
                if (user == null){
                    Intent intent=new Intent(MainActivity.this, SignUp.class);
                    startActivity(intent);
                    finish();
                }else{
                    Log.i("LOGGING___", user.getEmail());

                    Intent intent = new Intent(MainActivity.this, Insert_Medical_Report.class);
                    startActivity(intent);
                    finish();
                }
            }
        },SPLASH_SCREEN);



    }
}