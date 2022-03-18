package com.example.gp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Objects;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.ContentValues.TAG;

public class signupActivity extends AppCompatActivity {

EditText editTextemail,editTextpassword,editTextConfirmPassowrd;
CircleImageView profileImage;
Uri imageUri=null;
FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
StorageReference storageReference = FirebaseStorage.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        editTextemail=findViewById(R.id.email_sign);
        editTextpassword=findViewById(R.id.password_sign);
        editTextConfirmPassowrd=findViewById(R.id.confirm_password_sign);
        profileImage=findViewById(R.id.profile_image);


    }
    public  void  signup(View view){

}




    public void register(View view) {
        String email =editTextemail.getText().toString().trim();
        String password =editTextpassword.getText().toString().trim();
        String confirmpassword =editTextConfirmPassowrd.getText().toString().trim();
        if (imageUri==null){
            Toast.makeText(this,"please select image",Toast.LENGTH_SHORT).show();
            return;
        }
        if (email.isEmpty()|password.isEmpty()|confirmpassword.isEmpty()){

            Toast.makeText(this,"please fill all data",Toast.LENGTH_SHORT).show();
            return;

        }
        if (password.length()<6){

            Toast.makeText(this,"password should be at least 6 characters",Toast.LENGTH_SHORT).show();
        }
        if (!password.equals(confirmpassword)){

            Toast.makeText(this,"password not matching ",Toast.LENGTH_SHORT).show();
            return;
        }

        createUserByemail(email,password);

    }

    private void createUserByemail(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){

                        Toast.makeText(signupActivity.this,"account created",Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(signupActivity.this,Home.class);
                        String userID= task.getResult().getUser().getUid();
                        UploadProfileImage(userID);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        String errorMessage= Objects.requireNonNull(task.getException()).getLocalizedMessage();
                        Toast.makeText(signupActivity.this ,errorMessage, Toast.LENGTH_SHORT).show();
                        Log.i(TAG,"onComplete:"+errorMessage);
                    }
                });
    }

    private void UploadProfileImage(String userID) {
 storageReference.child("doctors profile").child(userID).putFile(imageUri);

     }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                imageUri = result.getUri();
                profileImage.setImageURI(imageUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    public void selectImage(View view) {
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);

    }
}
