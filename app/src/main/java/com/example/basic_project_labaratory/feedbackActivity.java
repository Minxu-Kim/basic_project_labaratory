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
        setContentView(R.layout.activity_feedback);     // 특정 날짜 식단 피드백 들어가는 버튼
        CalendarView calendar = (CalendarView) findViewById(R.id.calendar);     //putExtra, getExtra 이용해서 데이터 주고 받도록 코드 작성 해야함
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Intent intent = new Intent(getApplicationContext(), feedback2Activity.class);
                startActivity(intent);

            }
        });

    }
}