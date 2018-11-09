package com.example.travisryan.travisryanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Intent moves from title screen to next activity (selecting guest amount screen)
    public void getStarted(View view){
        Intent intent = new Intent(this, EnterGuestAmount.class);
        startActivity(intent);
    }

}
