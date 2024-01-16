package com.example.androidproject.models;

public class Transaction {
    private int id, account;
    private String date;
    //private Enum<String> type;
    private double amount, balance;

    public Transaction(int id, int account, String date, double balance, double amount){
        this.id = id;
        this.account = account;
        this.date = date;
        this.balance = balance;
        this.amount = amount;
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
}
