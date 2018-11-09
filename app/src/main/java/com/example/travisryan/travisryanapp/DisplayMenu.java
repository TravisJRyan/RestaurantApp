package com.example.travisryan.travisryanapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMenu extends AppCompatActivity {

    // By default, no items have been selected
    int pizza = 0;
    int broccoli = 0;
    int water = 0;
    int spaghetti = 0;
    int numberOfGuests = 0;
    TextView spaghettiTextView;
    TextView pizzaTextView;
    TextView broccoliTextView;
    TextView waterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Get number of guests from previous screen
        numberOfGuests = getIntent().getIntExtra("numberOfGuests", 0);
        System.out.println("FOUND "+numberOfGuests+" FROM LAST ACTIVITY");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_menu);
        // Store references to TextViews for updating values of items
        spaghettiTextView = (TextView) findViewById(R.id.spaghettiAmount);
        pizzaTextView = (TextView) findViewById(R.id.pizzaAmount);
        broccoliTextView = (TextView) findViewById(R.id.broccoliAmount);
        waterTextView = (TextView) findViewById(R.id.waterAmount);
    }

    // Triggered by plus button to increment
    public void incrementPizza(View view){
        pizza++;
        pizzaTextView.setText(String.valueOf(pizza));
    }

    // Triggered by plus button to increment
    public void incrementBroccoli(View view){
        broccoli++;
        broccoliTextView.setText(String.valueOf(broccoli));
    }

    // Triggered by plus button to increment
    public void incrementWater(View view){
        water++;
        waterTextView.setText(String.valueOf(water));
    }

    // Triggered by plus button to increment
    public void incrementSpaghetti(View view){
        spaghetti++;
        spaghettiTextView.setText(String.valueOf(spaghetti));
    }

    public void finish(View view){
        // Add quantities to intent for use in next activity
        Intent intent = new Intent(this, FinalResults.class);
        intent.putExtra("spaghetti", spaghetti);
        intent.putExtra("pizza", pizza);
        intent.putExtra("water", water);
        intent.putExtra("broccoli", broccoli);
        intent.putExtra("numberOfGuests", numberOfGuests);
        TextInputEditText tip = (TextInputEditText) findViewById(R.id.tip);
        intent.putExtra("tip", Integer.parseInt(tip.getText().toString().replaceAll("[^\\d.]", "")));
        startActivity(intent);
    }

}
