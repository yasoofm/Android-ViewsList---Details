package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.androidproject.models.Transaction;
import com.example.androidproject.models.Type;

public class TransactionDetailsActivity extends AppCompatActivity {

    TextView idTextView, accountTextView, dateTextView, typeTextView, balanceTextView, amountTextView;
    FrameLayout detailsTypeIcon, detailsAmountIcon;
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

            Drawable transferIcon = ResourcesCompat.getDrawable(getResources(), transaction.getTransferIcon(), null);
            Drawable withdrawIcon = ResourcesCompat.getDrawable(getResources(), transaction.getWithdrawIcon(), null);
            Drawable decreaseIcon = ResourcesCompat.getDrawable(getResources(), transaction.getDecreaseIcon(), null);
            Drawable depositIcon = ResourcesCompat.getDrawable(getResources(), transaction.getDepositIcon(), null);
            Drawable increaseIcon = ResourcesCompat.getDrawable(getResources(), transaction.getIncreaseIcon(), null);
            FrameLayout typeLayout = findViewById(R.id.detailsTypeIcon);
            FrameLayout amountLayout = findViewById(R.id.detailsAmountIcon);

            if(transaction.getType() == Type.WITHDRAWAL){
                typeLayout.setBackground(withdrawIcon);
                amountLayout.setBackground(decreaseIcon);
            } else if(transaction.getType() == Type.DEPOSIT){
                typeLayout.setBackground((depositIcon));
                amountLayout.setBackground(increaseIcon);
            } else if(transaction.getType() == Type.TRANSFER && transaction.getAmount() >= 0){
                typeLayout.setBackground(transferIcon);
                amountLayout.setBackground(increaseIcon);
            } else if(transaction.getType() == Type.TRANSFER && transaction.getAmount() < 0){
                typeLayout.setBackground(transferIcon);
                amountLayout.setBackground(decreaseIcon);
            }
        }
    }
}