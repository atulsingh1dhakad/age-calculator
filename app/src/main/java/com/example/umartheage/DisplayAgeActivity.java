package com.example.umartheage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DisplayAgeActivity extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_age);
        String name = getIntent().getStringExtra("name");
        int age = getIntent().getIntExtra("age", 0);



        TextView ageTextView = findViewById(R.id.ageTextView);
        ageTextView.setText(name + ", your age is " + age + " years.");
    }
}
