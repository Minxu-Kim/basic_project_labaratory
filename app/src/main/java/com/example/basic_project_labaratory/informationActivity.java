package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        //건강정보관리로 넘어가기
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), health.class);
                startActivity(intent);
            }
        });
        //웨어러블 디바이스 관리로 넘어가기
        wearable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), wearable.class);
                startActivity(intent);
            }
        });
        //비밀번호 및 보안으로 넘어가기
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), password.class);
                startActivity(intent);
            }
        });
    }
}
