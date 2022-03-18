package com.example.gp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static int splash_out_time = 3000;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (firebaseAuth.getCurrentUser()==null)
        {
            //go to login screen
            Intent intent=new Intent(MainActivity.this,loginActivity.class);
            startActivity(intent);
            finish();
            return;

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent log = new Intent( MainActivity.this, loginActivity.class);
                //hna B2OL YRO7 3LA AL LOGIN
                startActivity(log);
                finish();
            } },
                splash_out_time);

    }


}

