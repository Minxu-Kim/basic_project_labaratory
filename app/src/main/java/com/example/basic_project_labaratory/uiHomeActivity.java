package com.example.basic_project_labaratory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class uiHomeActivity extends AppCompatActivity {

    FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.personalinformationmanagement).setOnClickListener(onClickListener);
        findViewById(R.id.dietfeedback).setOnClickListener(onClickListener);
        findViewById(R.id.missionmanagement).setOnClickListener(onClickListener);
        findViewById(R.id.rank).setOnClickListener(onClickListener);
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.personalinformationmanagement:
                    myStartActivity(personalInformation_homeActivity.class);
                    break;
                case R.id.dietfeedback:
                    myStartActivity(feedbackActivity.class);
                    break;

                case R.id.missionmanagement:
                    myStartActivity(mission1Activity.class);
                    break;

                case R.id.rank:
                    myStartActivity(home2Activity.class);
                    break;

            }
        }
    };

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }




}
