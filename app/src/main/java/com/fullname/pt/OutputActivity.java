package com.fullname.pt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OutputActivity extends AppCompatActivity {
    private String squat, push, jack, crunch, food, cal;
    private TextView squatTV, pushTV, jackTV, crunchTV, foodTV, calTV;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        squatTV = findViewById(R.id.squatTextView);
        pushTV = findViewById(R.id.pushTextView);
        jackTV = findViewById(R.id.jackTextView);
        crunchTV = findViewById(R.id.crunchTextView);
        foodTV = findViewById(R.id.foodTextView);
        calTV = findViewById(R.id.calTextView);
        back = findViewById(R.id.cirBackButton);

        final String defString = "조회된 데이터가 없습니다!";

        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference mReference = FirebaseDatabase.getInstance().getReference().child(UID);
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Input input = dataSnapshot.getValue(Input.class);

                squatTV.setText("스쿼트 : " + input.getSquat() + "회");
                pushTV.setText("푸쉬업 : " + input.getPush() + "회");
                jackTV.setText("점핑잭 : " + input.getJac() + "초");
                crunchTV.setText("크런치 : " + input.getCrunch() + "회");
                foodTV.setText("섭취한 음식 목록 : " + input.getFood());
                calTV.setText("소모 칼로리 : " + input.getCal() + "kcal");

                // ...
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                squatTV.setText("스쿼트 : " + defString);
                pushTV.setText("푸쉬업 : " + defString);
                jackTV.setText("점핑잭 : " + defString);
                crunchTV.setText("크런치 : " + defString);
                foodTV.setText("섭취한 음식 목록 : " + defString);
                calTV.setText("소모 칼로리 : " + defString);
                // ...
            }
        };
        mReference.addValueEventListener(postListener);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
