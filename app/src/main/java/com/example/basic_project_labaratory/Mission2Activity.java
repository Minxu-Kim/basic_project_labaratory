package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Mission2Activity extends AppCompatActivity {
    @Override // 개인미션 화면
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission2);

        Button common = findViewById(R.id.common_mission2);
        Button personal = findViewById(R.id.personal_mission2);
        //공통미션으로 넘어가기
        common.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), mission1Activity.class);
                startActivity(intent);
            }
        });
    }
}