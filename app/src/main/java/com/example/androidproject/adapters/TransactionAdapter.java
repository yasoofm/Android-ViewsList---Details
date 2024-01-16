package com.example.androidproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.models.Transaction;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionHolder> {
    private ArrayList<Transaction> transactions;

    public TransactionAdapter(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }
    @NonNull
    @Override
    public TransactionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.history_item,
                parent,
                false
        );
        return new TransactionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionHolder holder, int position) {
        holder.dateTextView.setText(transactions.get(position).getDate());
        //holder.typeTextView.setText(transactions.get(position).get);
        holder.balanceTextView.setText(String.valueOf(transactions.get(position).getBalance()));
        holder.amountTextView.setText(String.valueOf(transactions.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class TransactionHolder extends RecyclerView.ViewHolder {
        TextView dateTextView, typeTextView, amountTextView, balanceTextView;

        public TransactionHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            balanceTextView = itemView.findViewById(R.id.balanceTextView);
        }
    }
}
