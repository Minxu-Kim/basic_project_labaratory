package com.example.basic_project_labaratory;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class personalInformationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activaty_login);

        TextView height = (TextView) findViewById(R.id.heightinput);
        TextView weight = (TextView) findViewById(R.id.weightinput);
        TextView age = (TextView) findViewById(R.id.ageinput);

        findViewById(R.id.signUpForPersonalInformation).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.signUpForPersonalInformation:
                    break;

            }
        }
    };
}
