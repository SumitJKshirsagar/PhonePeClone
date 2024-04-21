package com.example.phonepay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.phonepay.R;

import java.util.ArrayList;


public class HomeViewPagerAdapter extends PagerAdapter {

     private Context context;
    private ArrayList<Integer> offerList;

    public HomeViewPagerAdapter(Context context, ArrayList<Integer> offerList){
        this.context=context;
        this.offerList=offerList;
    }
    @Override
    public int getCount() {
        return offerList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,int position){
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_offer,container,false);
        ImageView txOffer = view.findViewById(R.id.conatainzone);
        txOffer.setImageResource(offerList.get(position));
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
      View view = (View)object;
      container.removeView(view);
    }
}
