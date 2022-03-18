package com.example.gp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class addStudent extends AppCompatActivity {
    EditText UserNameNewStudent,idNewStudent,EmailNewStudent,PasswordNewStudent;
    Button addNewStudent;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
CheckBox ch1,ch2,ch3,ch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        ch1=(CheckBox)findViewById(R.id.year1) ;
        ch2=(CheckBox)findViewById(R.id.year2) ;
        ch3=(CheckBox)findViewById(R.id.year3) ;
        ch4=(CheckBox)findViewById(R.id.year4) ;

        UserNameNewStudent=findViewById(R.id.UserNameNewStudent);
        idNewStudent=findViewById(R.id.idNewStudent);
        EmailNewStudent=findViewById(R.id.EmailNewStudent);
        addNewStudent=findViewById(R.id.AddNewStudent);
        PasswordNewStudent=findViewById(R.id.passwordNewStudent);
        addNewStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Student");
                String name = UserNameNewStudent.getText().toString();
                String id = idNewStudent.getText().toString();
                String email = EmailNewStudent.getText().toString();
                String password = PasswordNewStudent.getText().toString();


                String years=null;
                AddStudentHelper addStudentHelper = new AddStudentHelper(name, id, email, password,years);
                reference.child(id).setValue(addStudentHelper);
            }
        });

    }
}