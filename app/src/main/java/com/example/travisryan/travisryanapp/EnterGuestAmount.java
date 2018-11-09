package com.example.travisryan.travisryanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EnterGuestAmount extends AppCompatActivity {

    // EditText box stores number of guests inputted by user
    EditText numberOfGuestsInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_guest_amount);
    }

    public void guestsChosen(View view){
        TextView numberOfGuests = (TextView) findViewById(R.id.numberOfGuestsInput);
        // Remove all non-integers in the input and parse an integer
        int chosenGuests = Integer.parseInt(numberOfGuests.getText().toString().replaceAll("[^\\d.]", ""));
        Intent intent;
        // If no guests were chosen, start the same screen over again
        if(chosenGuests == 0) {
            intent = new Intent(this, EnterGuestAmount.class);
        } else{
            intent = new Intent(this, DisplayMenu.class);
        }
        // Add number of guests to intent for next screen
        intent.putExtra("numberOfGuests", chosenGuests);
        startActivity(intent);
    }
}
