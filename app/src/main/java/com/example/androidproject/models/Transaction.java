package com.example.androidproject.models;

import java.io.Serializable;

public class Transaction implements Serializable {
    private int id, account;
    private String date;
    private Type type;
    private double amount, balance;

    public Transaction(int id, int account, String date, double balance, double amount, Type type){
        this.id = id;
        this.account = account;
        this.date = date;
        this.balance = balance;
        this.amount = amount;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccount() {
        return account;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }
}
