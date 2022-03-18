package com.example.gp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    TextView addStudent,bonus,upload,sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addStudent=findViewById(R.id.addStudent);
        bonus=findViewById(R.id.bonus);
        upload=findViewById(R.id.upload);
        sum=findViewById(R.id.total);
        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=  new Intent(Home.this,addStudent.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        bonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(Home.this,bonus.class);
                startActivity(intent);
                finish();
                return;

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(Home.this,upload.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=  new Intent(Home.this,total.class);
                startActivity(intent);
                finish();
                return;
            }
        });
    }

}