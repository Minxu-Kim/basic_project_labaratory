package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import android.graphics.Color;
import java.util.ArrayList;

public class feedback2Activity extends AppCompatActivity {
    @Override // 식단 피드백 2 - 일별 식단 피드백
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback2);

        // getExtra로 feedbackActivity로부터 날짜정보 받아오기
        int year = getIntent().getIntExtra("intYear", 1);
        int month = getIntent().getIntExtra("intMonth", 1);
        int day = getIntent().getIntExtra("intDay", 1);

        // 식단 피드백 2 - 제목 표시용 버튼 및 텍스트
        Button feedback2ActivityTitle = findViewById(R.id.feedback2ActivityTitle);
        feedback2ActivityTitle.setText(year + "년 " + month + "월 " + day + "일 식단 피드백");

        ///////// 일일 영양섭취 차트 데이터 ////////////////////////////
        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> nutritionTotal = new ArrayList<>();
        nutritionTotal.add(new BarEntry(1, 1900));

        BarDataSet barDataSet = new BarDataSet(visitors, "Visitors");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);


        /////////////////////////////////////////////////////////////

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
