package com.example.androidproject.repositories;

import com.example.androidproject.models.Transaction;
import com.example.androidproject.models.Type;

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
            Transaction transaction = new Transaction(i + 1, i + 1, String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.MONTH) + 1) + "/" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)), 500.5, 200.5, Type.WITHDRAW);
            transactions.add(transaction);
        }
        return transactions;
    }
}
