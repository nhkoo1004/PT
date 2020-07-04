package com.fullname.pt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputActivity extends AppCompatActivity {
    private EditText squatET, pushET, jackET, crunchET, foodET, calET;
    private String squat, push, jack, crunch, food, cal;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        String UID = FirebaseAuth.getInstance().getCurrentUser().getUid();
        squatET = findViewById(R.id.editTextSquat);
        pushET = findViewById(R.id.editTextPush);
        jackET = findViewById(R.id.editTextJack);
        crunchET = findViewById(R.id.editTextCrunch);
        foodET = findViewById(R.id.editTextFood);
        calET = findViewById(R.id.editTextCal);

        submit = findViewById(R.id.cirSubmitButton);

        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child(UID);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squat = squatET.getText().toString();
                push = pushET.getText().toString();
                jack = jackET.getText().toString();
                crunch = crunchET.getText().toString();
                food = foodET.getText().toString();
                cal = calET.getText().toString();

                Input input = new Input();
                input.setSquat(squat);
                input.setPush(push);
                input.setJac(jack);
                input.setCrunch(crunch);
                input.setFood(food);
                input.setCal(cal);

                mDatabase.setValue(input);
                finish();
            }
        });

    }
}
