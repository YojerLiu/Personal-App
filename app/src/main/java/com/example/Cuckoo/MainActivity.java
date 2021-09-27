package com.example.Cuckoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void logout(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Logged out!", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, StartActivity.class));
    }

    public void addItemToDatabase(View view)
    {
        EditText editText = findViewById(R.id.item);
        String text = editText.getText().toString();
        if(text.isEmpty())
        {
            Toast.makeText(this, "No item entered!", Toast.LENGTH_LONG).show();
        }
        else
        {
            FirebaseDatabase.getInstance().getReference().child("User Resources").push().child("Name").setValue(text);
        }
    }
}