package com.example.Cuckoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.Cuckoo.MESSAGE";
    String msg = "Cuckoo: ";

    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event is running");
    }

    // Called when the activity is about to become visible.
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event is running");
    }

    // Called when the activity has become visible.
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event is running");
    }

    // Called when another activity is taking focus.
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event is running");
    }

    // Called when the activity is no longer visible.
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event is running");
    }

    // Called just before the activity is destroyed.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event is running");
    }

    // Called when the user taps the Send button
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editTextTextPersonName3);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}