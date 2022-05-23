package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class personalInformationInitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information_init);

        TextView height = (TextView) findViewById(R.id.heighttextview);
        TextView weight = (TextView) findViewById(R.id.weighttextview);
        TextView age = (TextView) findViewById(R.id.agetextview);

        findViewById(R.id.signUpForPersonalInformation).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.signUpForPersonalInformation:
                    profileUpdate();
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                    break;

            }
        }
    };
    private void profileUpdate() {
        String weight = ((EditText) findViewById(R.id.weightinput)).getText().toString();
        String height = ((EditText) findViewById(R.id.heightinput)).getText().toString();
        String age = ((EditText) findViewById(R.id.ageinput)).getText().toString();
        String name = ((EditText) findViewById(R.id.inputname)).getText().toString();

        if (height.length() > 0 && weight.length() > 0 && age.length() > 0 && name.length() > 0) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            memberinput memberinput = new memberinput(weight, height, age, name);
            if (user != null) {
                db.collection("users").document(user.getUid()).set(memberinput)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void avoid) {
                                StartToast("회원정보 등록에 성공하였습니다.");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                StartToast("회원정보 등록에 실패하였습니다.");
                            }
                        });

            }
        }
    }
        private void StartToast (String msg){
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }

}
