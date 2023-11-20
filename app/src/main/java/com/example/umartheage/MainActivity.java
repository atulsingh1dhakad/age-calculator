package com.example.umartheage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;

public class MainActivity extends AppCompatActivity {

    private DatePicker mDatePicker;
    private EditText mNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatePicker = findViewById(R.id.datePicker);
        mNameEditText = findViewById(R.id.naam);
        mDatePicker.setMaxDate(System.currentTimeMillis());
    }

    public void calculateAge(View view) {
        String name = mNameEditText.getText().toString();
        if (name.isEmpty()) {
            Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
            return;
        }

        int year = mDatePicker.getYear();
        int month = mDatePicker.getMonth();
        int day = mDatePicker.getDayOfMonth();

        LocalDate dob = LocalDate.of(year, month+1, day);
        LocalDate now = LocalDate.now();

        int age = Period.between(dob, now).getYears();

        Intent intent = new Intent(this, DisplayAgeActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        startActivity(intent);
    }
}