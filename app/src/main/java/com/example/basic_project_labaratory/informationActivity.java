package com.example.basic_project_labaratory;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class informationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        TextView textView = (TextView) findViewById(R.id.profile);
        Button health = findViewById(R.id.health);
        Button wearable = findViewById(R.id.wearable);
        Button password = findViewById(R.id.password);
    }
}