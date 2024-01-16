package com.example.androidproject.repositories;

import com.example.androidproject.models.Transaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

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
        for(int i = 0; i < numberOfItems; i++){
            Transaction transaction = new Transaction(i + 1, i + 1, String.valueOf(Calendar.getInstance().getTime()), 500.5, 200.5);
            transactions.add(transaction);
        }
        return transactions;
    }
}
