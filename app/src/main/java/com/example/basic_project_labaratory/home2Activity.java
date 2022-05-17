package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        Button ranking = findViewById(R.id.ranking);
        Button mygroup = findViewById(R.id.mygroup);

        //랭킹 화면으로 넘어가기
        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ranking1Activity.class);
                startActivity(intent);
            }
        });

        //소그룹 화면으로 넘어가기
        mygroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MygroupActivity.class);
                startActivity(intent);
            }
        });
    }
}