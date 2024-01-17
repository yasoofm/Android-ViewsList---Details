package com.example.androidproject.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.interfaces.TransactionItemListener;
import com.example.androidproject.models.Transaction;
import com.example.androidproject.models.Type;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionHolder> {
    private ArrayList<Transaction> transactions;
    private TransactionItemListener transactionItemListener;
    private Context context;

    public TransactionAdapter(ArrayList<Transaction> transactions, TransactionItemListener transactionItemListener, Context context){
        this.transactions = transactions;
        this.transactionItemListener = transactionItemListener;
        this.context = context;
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
        holder.typeTextView.setText(String.valueOf(transactions.get(position).getType()));
        holder.balanceTextView.setText(String.valueOf(transactions.get(position).getBalance()));
        holder.amountTextView.setText(String.valueOf(transactions.get(position).getAmount()));

//        Drawable withdrawIcon, depositIcon, transferIcon, decreaseIcon, increaseIcon;
//        withdrawIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getWithdrawIcon(), null);

        if(transactions.get(position).getType() == Type.WITHDRAWAL){
            Drawable withdrawIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getWithdrawIcon(), null);
            Drawable decreaseIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getDecreaseIcon(), null);
            holder.typeLayout.setBackground(withdrawIcon);
            holder.amountLayout.setBackground(decreaseIcon);
        } else if(transactions.get(position).getType() == Type.DEPOSIT){
            Drawable depositIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getDepositIcon(), null);
            Drawable increaseIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getIncreaseIcon(), null);
            holder.typeLayout.setBackground(depositIcon);
            holder.amountLayout.setBackground(increaseIcon);
        } else if(transactions.get(position).getType() == Type.TRANSFER && transactions.get(position).getAmount() >= 0) {
            Drawable transferIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getTransferIcon(), null);
            Drawable increaseIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getIncreaseIcon(), null);
            holder.typeLayout.setBackground(transferIcon);
            holder.amountLayout.setBackground(increaseIcon);
        } else if(transactions.get(position).getType() == Type.TRANSFER && transactions.get(position).getAmount() < 0) {
            Drawable transferIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getTransferIcon(), null);
            Drawable decreaseIcon = ResourcesCompat.getDrawable(context.getResources(), transactions.get(position).getDecreaseIcon(), null);
            holder.typeLayout.setBackground(transferIcon);
            holder.amountLayout.setBackground(decreaseIcon);
        }

        holder.itemView.setOnClickListener(v -> {
            transactionItemListener.onTransactionItemClick(transactions.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return transactions.size();
    }

    public static class TransactionHolder extends RecyclerView.ViewHolder {
        TextView dateTextView, typeTextView, amountTextView, balanceTextView;
        FrameLayout amountLayout, typeLayout;

        public TransactionHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            balanceTextView = itemView.findViewById(R.id.balanceTextView);
            amountLayout = itemView.findViewById(R.id.amountIcon);
            typeLayout = itemView.findViewById(R.id.typeIcon);

        }
    }
}
