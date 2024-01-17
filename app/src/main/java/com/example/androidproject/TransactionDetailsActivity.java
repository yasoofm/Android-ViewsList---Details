package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.androidproject.models.Transaction;

public class TransactionDetailsActivity extends AppCompatActivity {

    TextView idTextView, accountTextView, dateTextView, typeTextView, balanceTextView, amountTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);

        idTextView = findViewById(R.id.detailsId);
        accountTextView = findViewById(R.id.detailsAccount);
        dateTextView = findViewById(R.id.detailsDate);
        typeTextView = findViewById(R.id.detailsType);
        balanceTextView = findViewById(R.id.detialsBalance);
        amountTextView = findViewById(R.id.detailsAmount);

        Transaction transaction = (Transaction) getIntent().getSerializableExtra("TRANSACTION_KEY");
        if(transaction != null){
            idTextView.setText(String.valueOf(transaction.getId()));
            accountTextView.setText(String.valueOf(transaction.getAccount()));
            dateTextView.setText(transaction.getDate());
            typeTextView.setText(String.valueOf(transaction.getType()));
            balanceTextView.setText(String.valueOf(transaction.getBalance()));
            amountTextView.setText(String.valueOf(transaction.getAmount()));
        }
    }
}