package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class feedback3Activity extends AppCompatActivity {
    @Override // 식단 피드백 3 - 개별 식사 상세정보
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback3);

        // 식단 피드백 3 - 제목 표시용 버튼 및 텍스트
        Button feedback3ActivityTitle = findViewById(R.id.feedback3ActivityTitle);
        feedback3ActivityTitle.setText("(날짜) 식사 " +
                feedback2Activity.getMealNumber() + " 상세정보");
        // 식단 피드백 3 - 식사 내용 표시용 버튼 및 텍스트
        Button MealDetails = findViewById(R.id.mealDetails);
        MealDetails.setText("식사 " +
                feedback2Activity.getMealNumber() + " - 내용");

        // 홈 화면으로 돌아가는 홈으로 버튼
        Button toMain = findViewById(R.id.toMainFromFeedback3);

        //홈 화면으로 돌아가기
        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), uiHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}