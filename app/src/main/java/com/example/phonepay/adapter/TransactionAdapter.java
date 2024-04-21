package com.example.phonepay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonepay.R;
import com.example.phonepay.model.TransactionModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ViewHolder> {

    private ArrayList<TransactionModel> txnList;
    private Context context;


    public TransactionAdapter(ArrayList<TransactionModel> txnList, Context context) {
        this.context= context;
        this.txnList = txnList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txmImg.setImageResource(txnList.get(position).getImg_txn_way());
        holder.txnDate.setText(txnList.get(position).getTxn_date());
        holder.txtTxtView.setText(txnList.get(position).getTxn_med());
        holder.txnDealer.setText(txnList.get(position).getTxn_dealer());
        holder.txnAmt.setText(txnList.get(position).getTxn_amt());
        holder.txnAmtDebCred.setText(txnList.get(position).getTxn_amt_cd());
    }

    @Override
    public int getItemCount() {
        return txnList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView txmImg;
        private TextView txnDate,txtTxtView,txnDealer,txnAmt,txnAmtDebCred;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txmImg = itemView.findViewById(R.id.imv_transaction_type);
            txnDate = itemView.findViewById(R.id.txt_transaction_date);
            txtTxtView = itemView.findViewById(R.id.txn_transaction_type);
            txnDealer = itemView.findViewById(R.id.txn_transaction_merchant);
            txnAmt = itemView.findViewById(R.id.txn_transaction_amount);
            txnAmtDebCred = itemView.findViewById(R.id.txn_transaction_cred_deb);

        }
    }
}
