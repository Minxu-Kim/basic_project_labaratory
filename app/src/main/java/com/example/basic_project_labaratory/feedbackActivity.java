package com.example.basic_project_labaratory;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class feedbackActivity extends AppCompatActivity {
    @Override // 식단 피드백 1 - 식단 피드백 메인페이지 (기간별)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
    }
}