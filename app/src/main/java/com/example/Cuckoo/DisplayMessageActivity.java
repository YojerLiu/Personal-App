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

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(StartActivity.EXTRA_MESSAGE);

        // Capture the layout's Textview and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message.toUpperCase());
        if(textView.getText().equals("CUCKOO"))
        {
            textView.setText("A surprise!");
        }
    }

    public void enterChatInterface(View view)
    {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }
}