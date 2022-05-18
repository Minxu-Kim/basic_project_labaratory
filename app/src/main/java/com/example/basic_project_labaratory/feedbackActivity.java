package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class feedbackActivity extends AppCompatActivity {
    @Override // 식단 피드백 1 - 식단 피드백 메인페이지 (기간별)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // 특정 날짜 식단 피드백 들어가는 버튼
        Button daily = findViewById(R.id.calendar);

        // 달력에서 특정 날짜 식단 피드백 화면으로 넘어가기
        daily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback2Activity.class);
                startActivity(intent);
            }
        });
    }
}