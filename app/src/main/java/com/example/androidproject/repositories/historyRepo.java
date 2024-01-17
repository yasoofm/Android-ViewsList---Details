package com.example.androidproject.repositories;

import com.example.androidproject.R;
import com.example.androidproject.models.Transaction;
import com.example.androidproject.models.Type;

import java.util.ArrayList;
import java.util.Calendar;

public class historyRepo {
    private static historyRepo instance;

    private historyRepo(){

    }

    public static historyRepo getInstance(){
        if(instance == null){
            instance = new historyRepo();
        }
        return instance;
    }

    public ArrayList<Transaction> dummyTransactions(int numberOfItems){
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1431, 3421, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), 500.5, -100, Type.WITHDRAWAL, R.drawable.cash_withdrawal, R.drawable.payment, R.drawable.money_transfer, R.drawable.growth, R.drawable.price_down));
        transactions.add(new Transaction(2321, 3421, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), 500.5, 30, Type.DEPOSIT, R.drawable.cash_withdrawal, R.drawable.payment, R.drawable.money_transfer, R.drawable.growth, R.drawable.price_down));
        transactions.add(new Transaction(3432, 3421, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), 500.5, 500, Type.TRANSFER, R.drawable.cash_withdrawal, R.drawable.payment, R.drawable.money_transfer, R.drawable.growth, R.drawable.price_down));
        transactions.add(new Transaction(4432, 3421, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), 500.5, -322, Type.TRANSFER, R.drawable.cash_withdrawal, R.drawable.payment, R.drawable.money_transfer, R.drawable.growth, R.drawable.price_down));
        transactions.add(new Transaction(5243, 3421, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), 500.5, 700, Type.DEPOSIT, R.drawable.cash_withdrawal, R.drawable.payment, R.drawable.money_transfer, R.drawable.growth, R.drawable.price_down));
        return transactions;
    }
}
