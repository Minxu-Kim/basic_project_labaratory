package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mission1Activity extends AppCompatActivity {
    private ArrayList<Mission1Data> listData = new ArrayList<>();
    private Mission1Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission1);

        Button common = findViewById(R.id.common_mission);
        Button personal = findViewById(R.id.personal_mission);
        //개인미션으로 넘어가기
        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Mission2Activity.class);
                startActivity(intent);
            }
        });


        //리사이클러뷰
        init();
        getData();

    }

    public void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new Mission1Adapter(this, listData);
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        List<String> listContent = Arrays.asList("아침 먹기", "점심 먹기", "저녁 먹기");
        for (int i = 0; i < listContent.size(); i++) {
            Mission1Data data = new Mission1Data();
            data.setContent(listContent.get(i));

            adapter.additem(data);
        }
        adapter.notifyDataSetChanged();
    }
}