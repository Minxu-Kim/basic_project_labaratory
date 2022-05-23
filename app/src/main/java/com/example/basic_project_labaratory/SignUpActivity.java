package com.example.basic_project_labaratory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basic_project_labaratory.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;


public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activaty_sign_up);

        TextView email = (TextView) findViewById(R.id.Email);
        TextView password = (TextView) findViewById(R.id.Password);
        TextView passwordconfirm = (TextView) findViewById(R.id.passwordconfirm);
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.SignUpinSignUpActivity).setOnClickListener(onClickListener);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.SignUpinSignUpActivity:
                    signUp();
                    break;
            }
        }
    };



    private void signUp() {
        String email = ((EditText)findViewById(R.id.editTextTextEmailAddress)).getText().toString();
        String password = ((EditText)findViewById(R.id.editTextTextPassword)).getText().toString();
        String passwordCheck = ((EditText)findViewById(R.id.editTextTextPassword)).getText().toString();

        if(email.length() > 0 && password.length() > 0 && passwordCheck.length() > 0){
            if(password.equals(passwordCheck)){
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    StartToast( "회원가입에 성공하였습니다.");
                                    myStartActivity(personalInformationInitActivity.class);
                                } else {
                                    if(task.getException() != null){
                                        StartToast( task.getException().toString());
                                    }
                                }
                            }
                        });
            }else{
                StartToast( "비밀번호가 일치하지 않습니다.");
            }
        }else {
            StartToast( "이메일 또는 비밀번호를 입력해 주세요.");
        }
    }
    private void StartToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void myStartActivity(Class c) {
        Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
