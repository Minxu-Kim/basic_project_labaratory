package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Ranking2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank2);
        Button group = findViewById(R.id.group_ranking2);
        Button personal = findViewById(R.id.personal_ranking2);

        //개인랭킹으로 넘어가기
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ranking1Activity.class);
                startActivity(intent);
            }
        });
    }
}