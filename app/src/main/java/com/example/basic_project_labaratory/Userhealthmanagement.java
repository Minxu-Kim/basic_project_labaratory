package com.example.basic_project_labaratory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Userhealthmanagement extends AppCompatActivity {


    FirebaseUser firebaseUser;

    private final String TAG = "Userhealthmanagement";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_health);

        init();


}

    private void init(){
        EditText age =((EditText) findViewById(R.id.ai));
        EditText height =((EditText) findViewById(R.id.hi));
        EditText weight =((EditText) findViewById(R.id.wi));
        TextView mainText =((TextView) findViewById(R.id.nameText));
        FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser == null){
            myStartActivity(SignUpActivity.class);
        }else{
            DocumentReference documentReference = FirebaseFirestore.getInstance().collection("users").document(firebaseUser.getUid());
            documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        DocumentSnapshot document = task.getResult();
                        if(document != null) {
                            if(document.exists()){
                                Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                                age.setText(document.getData().get("age").toString());
                                height.setText(document.getData().get("height").toString());
                                weight.setText(document.getData().get("weight").toString());
                                mainText.setText(document.getData().get("name").toString() + "의 건강정보");
                            }else{
                                Log.d(TAG, "No such document");
                                myStartActivity(personalInformationActivity.class);
                            }
                        }
                    }
                }
            });
        }
    }

    private void myStartActivity(Class c) {
    Intent intent = new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
}
}


