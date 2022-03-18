package com.example.gp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class loginActivity extends AppCompatActivity {
    EditText editTextemail,editTextpassword;
    public void  signup(View view) {
        Intent intent = new Intent(loginActivity.this, signupActivity.class);
        startActivity(intent);
    }
FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextemail=findViewById(R.id.userName);
        editTextpassword=findViewById(R.id.password);

    }

    public void login (View view){
        String email=editTextemail.getText().toString();
        String password=editTextpassword.getText().toString();
        if (email.isEmpty()|password.isEmpty()){

            Toast.makeText(this,"please fill all data",Toast.LENGTH_SHORT).show();
            return;

        }
        if (password.length()<6){

            Toast.makeText(this,"password should be at least 6 characters",Toast.LENGTH_SHORT).show();
        }
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   if  (task.isSuccessful()){
                       Intent intent= new Intent(loginActivity.this,Home.class);
                       startActivity(intent);
                       finish();
                        }
                   else {
                       String errorMessage=task.getException().getLocalizedMessage();
                       Toast.makeText(loginActivity.this ,errorMessage, Toast.LENGTH_SHORT).show();

                   }
                    }
                });
    }


}