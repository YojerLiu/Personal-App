package com.example.Cuckoo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        EditText email = findViewById(R.id.email);
        String txt_email = email.getText().toString();
        EditText password = findViewById(R.id.password);
        String txt_password = password.getText().toString();

        if (txt_password.equals("") || txt_email.equals("")) {
            Toast.makeText(this, "Empty credentials!", Toast.LENGTH_LONG).show();
        } else if (txt_email.length() < 6) {
            Toast.makeText(this, "Password is too short!", Toast.LENGTH_LONG).show();
        } else {
            auth.createUserWithEmailAndPassword(txt_email, txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Register successfully!", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        finish();
                    }else{
                        Toast.makeText(RegisterActivity.this, "Register failed!", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}