package com.example.travisryan.travisryanapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class FinalResults extends AppCompatActivity {

    // Four menu items are used to calculate total prices
    MenuItem broccoli;
    MenuItem pizza;
    MenuItem spaghetti;
    MenuItem water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_results);
        // Get values from previous activities
        int broccoliAmount = getIntent().getIntExtra("broccoli", 0);
        int pizzaAmount = getIntent().getIntExtra("pizza", 0);
        int waterAmount = getIntent().getIntExtra("water", 0);
        int spaghettiAmount = getIntent().getIntExtra("spaghetti", 0);
        double tipPercent = (double)getIntent().getIntExtra("tip", 15)/100;
        int numberOfGuests = getIntent().getIntExtra("numberOfGuests", 1);
        // Use an ArrayList to store all the items
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        // Instantiate the four possible menu items
        broccoli = new MenuItem("broccoli", 1.00, broccoliAmount);
        pizza = new MenuItem("pizza", 14.50, pizzaAmount);
        spaghetti = new MenuItem("spaghetti", 20.00, spaghettiAmount);
        water = new MenuItem("water", 3.00, waterAmount);
        // Add menu items to ArrayList
        items.add(broccoli);
        items.add(pizza);
        items.add(spaghetti);
        items.add(water);
        // Use math to generate important values for final screen
        double total=getTotalItemCost(items);
        double tipAmount = total*tipPercent;
        double finalTotal = total+tipAmount;
        double amountPerPerson = finalTotal/numberOfGuests;
        // Update TextView boxes in screen to display totals
        TextView pizzaAmountTextView = (TextView) findViewById(R.id.pizzaAmount);
        pizzaAmountTextView.setText(String.valueOf(pizzaAmount));
        TextView spaghettiAmountTextView = (TextView) findViewById(R.id.spaghettiAmount);
        spaghettiAmountTextView.setText(String.valueOf(spaghettiAmount));
        TextView broccoliAmountTextView = (TextView) findViewById(R.id.broccoliAmount);
        broccoliAmountTextView.setText(String.valueOf(broccoliAmount));
        TextView waterAmountTextView = (TextView) findViewById(R.id.waterAmount);
        waterAmountTextView.setText(String.valueOf(waterAmount));
        TextView totalCostTextView = (TextView) findViewById(R.id.totalCost);
        totalCostTextView.setText("$"+new DecimalFormat("#.##").format(total).toString());
        TextView tipTextView = (TextView) findViewById(R.id.tip);
        tipTextView.setText("$"+new DecimalFormat("#.##").format(tipAmount).toString());
        TextView finalCostTextView = (TextView) findViewById(R.id.finalCost);
        finalCostTextView.setText("$"+new DecimalFormat("#.##").format(finalTotal).toString());
        TextView perPersonTextView = (TextView) findViewById(R.id.costPerPerson);
        perPersonTextView.setText("$"+new DecimalFormat("#.##").format(amountPerPerson).toString()+" ( x "+numberOfGuests+" guests)");
    }

    // A method that takes a collection of menu items and finds the total cost based on their prices/quantities
    private double getTotalItemCost(ArrayList<MenuItem> items){
        double total = 0;
        for(MenuItem item : items){
            total += item.price*item.quantity;
        }
        return total;
    }

}
