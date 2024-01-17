package com.example.androidproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidproject.adapters.TransactionAdapter;
import com.example.androidproject.interfaces.TransactionItemListener;
import com.example.androidproject.models.Transaction;

import java.util.ArrayList;
import com.example.androidproject.repositories.historyRepo;
public class MainActivity extends AppCompatActivity implements TransactionItemListener {

    RecyclerView historyRecyclerView;
    ArrayList<Transaction> transactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transactions = historyRepo.getInstance().dummyTransactions(7);

        historyRecyclerView = findViewById(R.id.historyRecyclerView);
        historyRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        TransactionAdapter transactionAdapter = new TransactionAdapter(transactions, this, getApplicationContext());
        historyRecyclerView.setAdapter(transactionAdapter);


    }

    @Override
    public void onTransactionItemClick(Transaction transaction) {
        Intent intent = new Intent(MainActivity.this, TransactionDetailsActivity.class);
        intent.putExtra("TRANSACTION_KEY", transaction);
        startActivity(intent);
    }
}