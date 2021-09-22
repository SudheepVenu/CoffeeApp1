package com.example.coffeeapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //create variables
    int noOfCoffee = 0;
    int priceOfCoffee = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //method for submitOrder Button
    public void submitOrder(View view) {
        //call the method display() is called when the order button is clicked
        // display(1);
        // get user name
        EditText nameField = findViewById(R.id.name_field);
        CheckBox whippedCreamCheckbox = findViewById(R.id.Whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();
        // user wants chocolate
        String name = nameField.getText().toString();
        // user wants whipped cream
        CheckBox ChocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = ChocolateCheckBox.isChecked();
        // calculate price
        int price = calculatePrice(hasWhippedCream, hasChocolate);
        //create an order summary
        String message = createOrderSummary(name, price, hasWhippedCream, hasChocolate);

        //int totalPrice=noOfCoffee*priceOfCoffee;
        //TextView priceTextView = findViewById(R.id.price_text_view);
        //priceTextView.setText("Name " + name + "\n" + " Total $"+ totalPrice + "\n" +"Thank You ! " );

        // create an Intent to send the message to the new activity that has been created
        Intent intent = new Intent(this, DisplayOrderDetails.class);
        intent.putExtra("message", message);
        intent.putExtra("name", name);
        intent.putExtra("price",Integer.toString(price));
        startActivity(intent);


    }

    // method to create a message
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name " + name + "\n" +
                "Add Whipped Cream? " + addWhippedCream + "\n" +
                "Add Chocolate? " + addChocolate + "\n" +
                "Quantity : " + noOfCoffee + "\n" +
                "Total : $" + price + "\n" +
                "Thank you ! ";
        return priceMessage;

    }

    // method to calculate the price
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int basePrice = 5;
        if (hasWhippedCream == true) {
            basePrice = basePrice + 1;
        }
        if (hasChocolate == true) {
            basePrice = basePrice + 2;
        }
        int finalPrice = basePrice * noOfCoffee;
        return finalPrice;
    }

    private void display(int i) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + i);

    }

    //increase no of coffee with increment
    public void incerement(View view) {
        noOfCoffee = noOfCoffee + 1;
        if (noOfCoffee >= 10) {
            noOfCoffee = 10;
        }
        display(noOfCoffee);
    }

    //decrease no of coffee with decrement
    public void decrement(View view) {
        noOfCoffee = noOfCoffee - 1;
        if (noOfCoffee <= 1) {
            noOfCoffee = 1;
        }
        display(noOfCoffee);
    }

}