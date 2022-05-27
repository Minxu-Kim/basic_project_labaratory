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

        // getExtra로 feedbackActivity로부터 날짜 정보 및 일일 영양정보 받아오기
        int year = getIntent().getIntExtra("intYear", 1);
        int month = getIntent().getIntExtra("intMonth", 1);
        int day = getIntent().getIntExtra("intDay", 1);

        int cal = getIntent().getIntExtra("intCal", 1);
        int carbs = getIntent().getIntExtra("intCarbs", 1);
        int protein = getIntent().getIntExtra("intProtein", 1);
        int fat = getIntent().getIntExtra("intFat", 1);
        int sodium = getIntent().getIntExtra("intSodium", 1);



        // 식단 피드백 2 - 제목 표시용 버튼 및 텍스트
        Button feedback2ActivityTitle = findViewById(R.id.feedback2ActivityTitle);
        feedback2ActivityTitle.setText(year + "년 " + month + "월 " + day + "일 식단 피드백");

        ///// 차트 그리기 //////////
        Button calBar = findViewById(R.id.cal_bar);
        Button carbsBar = findViewById(R.id.carbs_bar);
        Button proteinBar = findViewById(R.id.protein_bar);
        Button fatBar = findViewById(R.id.fat_bar);
        Button sodiumBar = findViewById(R.id.sodium_bar);

        calBar.setHeight(150 * (cal/2000));
        carbsBar.setHeight(150 * (carbs/324));
        proteinBar.setHeight(150 * (protein/55));
        fatBar.setHeight(150 * (fat/54));
        sodiumBar.setHeight(150 * (sodium/2000));

        /////////////////////////

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
                // putExtra로 날짜정보와 mealNumber = 1 넘기기
                intent.putExtra("intYear", year);
                intent.putExtra("intMonth", month);
                intent.putExtra("intDay", day);
                intent.putExtra("intMealNumber", 1);
                startActivity(intent);
            }
        });

        // 식사 2 상세정보 화면으로 넘어가기
        meal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback3Activity.class);
                // putExtra로 날짜정보와 mealNumber = 2 넘기기
                intent.putExtra("intYear", year);
                intent.putExtra("intMonth", month);
                intent.putExtra("intDay", day);
                intent.putExtra("intMealNumber", 2);
                startActivity(intent);
            }
        });

        // 식사 3 상세정보 화면으로 넘어가기
        meal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedback3Activity.class);
                // putExtra로 날짜정보와 mealNumber = 3 넘기기
                intent.putExtra("intYear", year);
                intent.putExtra("intMonth", month);
                intent.putExtra("intDay", day);
                intent.putExtra("intMealNumber", 3);
                startActivity(intent);
            }
        });
    }

}
