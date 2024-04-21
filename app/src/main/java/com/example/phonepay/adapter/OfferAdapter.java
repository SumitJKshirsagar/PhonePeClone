package com.example.phonepay.adapter;

import android.content.Context;
import android.telecom.TelecomManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonepay.R;
import com.example.phonepay.model.OfferModel;

import java.util.ArrayList;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.ViewHolder> {
    private ArrayList<OfferModel> offerModelArrayList;
    private Context context;

    public OfferAdapter(Context context,ArrayList<OfferModel> offerModelArrayList) {
        this.context=context;
        this.offerModelArrayList = offerModelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_offers,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.offerImageView.setImageResource(offerModelArrayList.get(position).getImage());
        holder.offerItem.setText(offerModelArrayList.get(position).getOffer_on_offer());
        holder.offerDescription.setText(offerModelArrayList.get(position).getOffer_details());


    }

    @Override
    public int getItemCount() {
        return offerModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView offerImageView;
        private TextView offerItem,offerDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            offerImageView = itemView.findViewById(R.id.offer_img);
            offerItem = itemView.findViewById(R.id.offer_txt);
            offerDescription = itemView.findViewById(R.id.offer_info);
        }
    }
}
