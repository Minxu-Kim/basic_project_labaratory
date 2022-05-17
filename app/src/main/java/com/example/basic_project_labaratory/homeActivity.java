package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class homeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button dietfeedback = findViewById(R.id.dietfeedback);
        Button missionmanagement = findViewById(R.id.missionmanagement);
        Button rank = findViewById(R.id.rank);
        Button informationmanagement = findViewById(R.id.personalinformationmanagement);

        //식단피드백 화면으로 넘어가기
        dietfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), feedbackActivity.class);
                startActivity(intent);
            }
        });

        //미션화면으로 넘어가기
        missionmanagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mission1Activity.class);
                startActivity(intent);
            }
        });
        //랭킹 및 소그룹 화면으로 넘어가기
        rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), home2Activity.class);
                startActivity(intent);
            }
        });
        //정보관리 화면으로 넘어가기
        informationmanagement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), informationActivity.class);
                startActivity(intent);
            }
        });
    }
}


