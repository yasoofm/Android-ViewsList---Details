package com.example.androidproject.models;

import java.io.Serializable;

public class Transaction implements Serializable {
    private int id;
    private long account;
    private String date;
    private Type type;
    private double amount, balance;
    private int withdrawIcon, depositIcon, transferIcon, increaseIcon, decreaseIcon;

    public Transaction(int id, long account, String date, double balance, double amount, Type type, int withdrawIcon, int depositIcon, int transferIcon, int increaseIcon, int decreaseIcon){
        this.id = id;
        this.account = account;
        this.date = date;
        this.balance = balance;
        this.amount = amount;
        this.type = type;
        this.withdrawIcon = withdrawIcon;
        this.depositIcon = depositIcon;
        this.transferIcon = transferIcon;
        this.increaseIcon = increaseIcon;
        this.decreaseIcon = decreaseIcon;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public long getAccount() {
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
    public int getWithdrawIcon(){
        return withdrawIcon;
    }
    public int getDepositIcon(){
        return depositIcon;
    }
    public int getTransferIcon(){
        return transferIcon;
    }

    public int getIncreaseIcon() {
        return increaseIcon;
    }

    public int getDecreaseIcon() {
        return decreaseIcon;
    }
}
