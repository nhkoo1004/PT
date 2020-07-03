package com.fullname.pt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ButtonsActivity extends AppCompatActivity {
    private Button logout, input, output;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser==null){
            Intent intent = new Intent(ButtonsActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        logout = findViewById(R.id.cirLogoutButton);
        input = findViewById(R.id.cirInputButton);
        output = findViewById(R.id.cirOutputButton);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(ButtonsActivity.this, "로그아웃했습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ButtonsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
