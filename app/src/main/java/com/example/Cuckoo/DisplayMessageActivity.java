package com.example.Cuckoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

    }

    public void enterChatInterface(View view)
    {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }
}