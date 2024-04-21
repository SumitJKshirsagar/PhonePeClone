package com.example.phonepay.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.phonepay.R;
import com.example.phonepay.adapter.TransactionAdapter;
import com.example.phonepay.model.TransactionModel;

import java.util.ArrayList;


public class TransactionFragment extends Fragment {

    private Context context;
    private RecyclerView recyclerView;


    public TransactionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public static TransactionFragment newInstance() {
        TransactionFragment fragment = new TransactionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_transaction, container, false);
        initViews(view);
        ArrayList<TransactionModel> transactionModelArrayList = new ArrayList<>();
        transactionModelArrayList.add(new TransactionModel("1 day ago","Paid to",
                "Zomato","Rs."+"500","Debited from",R.drawable.ic_to_contact));
        transactionModelArrayList.add(new TransactionModel("1 day ago","Paid to",
                "flipkart","Rs."+"200","Debited from",R.drawable.ic_to_contact));
        transactionModelArrayList.add(new TransactionModel("2 day ago","Cashback",
                "Pizzahut","Rs."+"190","Credited to",R.drawable.ic_to_account));
        transactionModelArrayList.add(new TransactionModel("3 day ago","Paid to",
                "BigBazaar","Rs."+"1190","Debited from",R.drawable.ic_to_contact));
        transactionModelArrayList.add(new TransactionModel("4 day ago","Paid to",
                "Crompton","Rs."+"700","Debited from",R.drawable.ic_to_contact));
        transactionModelArrayList.add(new TransactionModel("5 day ago","Paid to",
                "AJIO","Rs."+"900","Debited from",R.drawable.ic_to_contact));
        transactionModelArrayList.add(new TransactionModel("7 day ago","Cashback",
                "Myntra","Rs."+"190","Credited to",R.drawable.ic_to_account));

        TransactionAdapter adapter = new TransactionAdapter(transactionModelArrayList,context);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.transaction_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}