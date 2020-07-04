package com.fullname.pt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {
    private String squat, push, jack, crunch, food, cal;
    private TextView squatTV, pushTV, jackTV, crunchTV, foodTV, calTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);


    }
}
