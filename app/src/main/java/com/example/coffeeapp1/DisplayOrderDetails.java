package com.example.coffeeapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
public class DisplayOrderDetails extends AppCompatActivity {
    String message;
    String name;
    String price;
    coffeeDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_order_details);
        dbHandler = new coffeeDBHandler(this,null,null,1);
        //get the intent from the MainActivity
        Intent intent = getIntent();
        message = intent.getStringExtra("message");
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        //set the string in the layout TextView
        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);
    }
    //method to run when the button is clicked to open Gmail
    public void sendEmail(View view) {
        String[] addresses = {"sudheep@gmail.com", "s3896541@rmit.edu.au"};
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    //button to save in SQLite database
    public void addButtonClicked(View view) {
        Order order = new Order(name,Integer.parseInt(price));
        dbHandler.addOrder(order);
        Toast.makeText(getApplicationContext(),"Data Saved!",Toast.LENGTH_SHORT).show();
    }
//method to send report details
    public void salesReport(View view) {
        String dbString = dbHandler.databaseToString();
        // start the new intent here
        Intent salesIntent = new Intent(this,DisplaySalesDetails.class);
        salesIntent.putExtra("db",dbString);
        startActivity(salesIntent);

    }
}