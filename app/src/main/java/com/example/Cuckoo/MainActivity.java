package com.example.Cuckoo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        List<String> list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Information");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot d : snapshot.getChildren()) {
                    PersonalResume PR = d.getValue(PersonalResume.class);
                    list.add(PR.toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Logged out!", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, StartActivity.class));
    }

    public void addItemToDatabase(View view) {
        EditText editText = findViewById(R.id.item);
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "No item entered!", Toast.LENGTH_LONG).show();
        } else {
            String email = (text + "@gmail.com").toLowerCase();
            FirebaseDatabase.getInstance().getReference().child("Information").child("branch" + (i++)).setValue(new PersonalResume(text, email));
        }
    }
}