package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class feedback2Activity extends AppCompatActivity {
    @Override // 식단 피드백 2 - 일별 식단 피드백
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback2);

        // 식사 1 상세정보 가는 버튼
        Button meal1 = findViewById(R.id.meal1);
        // 식사 2 상세정보 가는 버튼
        Button meal2 = findViewById(R.id.meal2);

        // 식사 1 상세정보 화면으로 넘어가기
        meal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback3Activity.class);
                startActivity(intent);
            }
        });

        // 식사 2 상세정보 화면으로 넘어가기
        meal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback3Activity.class);
                startActivity(intent);
            }
        });
    }
}
