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
        // 식사 3 상세정보 가는 버튼
        Button meal3 = findViewById(R.id.meal3);

        // 식사 1 상세정보 화면으로 넘어가기
        meal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback3Activity.class);
                startActivity(intent);
                // 식사1 버튼 클릭시: mealNumber = 1
                mealNumber = 1;
            }
        });

        // 식사 2 상세정보 화면으로 넘어가기
        meal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback3Activity.class);
                startActivity(intent);
                // 식사2 버튼 클릭시: mealNumber = 2
                mealNumber = 2;
            }
        });

        // 식사 3 상세정보 화면으로 넘어가기
        meal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback3Activity.class);
                startActivity(intent);
                // 식사3 버튼 클릭시: mealNumber = 3
                mealNumber = 3;
            }
        });
    }

    // 식사1, 식사2, 식사3 버튼 클릭시 mealNumber 변수에 1, 2, 3 저장
    // getMealNumber() 멤버로 본 public class 밖에서 접근할 수 있음
    // 이 데이터는 다음 화면인 feedback3Activity 에서 활용
    private static int mealNumber = 0;
    public static int getMealNumber(){return mealNumber;}


}
