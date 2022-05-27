package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class feedbackActivity extends AppCompatActivity {
    @Override // 식단 피드백 1 - 식단 피드백 메인페이지 (기간별)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // DB 에서 가져올 일일 영양정보
        int cal = 0, carbs = 0, protein = 0, fat = 0, sodium = 0;

        // 특정 날짜 식단 피드백 들어가는 달력 버튼
        CalendarView calendar = (CalendarView) findViewById(R.id.calendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Intent intent = new Intent(getApplicationContext(), feedback2Activity.class);
                // //putExtra, getExtra 이용해서 feedback2Activty로 달력의 날짜 보내기
                intent.putExtra("intYear", year);
                intent.putExtra("intMonth", month);
                intent.putExtra("intDay", day);

                // 일일 영양정보 넘기기 (차트 그리기)
                intent.putExtra("intCal", cal);
                intent.putExtra("intCarbs", carbs);
                intent.putExtra("intProtein", protein);
                intent.putExtra("intFat", fat);
                intent.putExtra("intSodium", sodium);

                startActivity(intent);

            }
        });

    }

}
