package com.example.phonepay.ui;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.phonepay.R;
import com.example.phonepay.adapter.HomeViewPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {
private Context context;
private ViewPager viewPager;
private LinearLayout lnrlyt;
private ArrayList<Integer> offerList;
private int count = 0;
private Timer timer;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    private void initViews(View view) {
        viewPager = view.findViewById(R.id.view_pager_home);
        lnrlyt = view.findViewById(R.id.ln_points_home);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        initViews(view);
        setupViewPager();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(() -> {
                    if(count<=5){
                        viewPager.setCurrentItem(count);
                        count++;
                    }else {
                        count=0;
                        viewPager.setCurrentItem(count);
                    }
                });
            }
        },500,2000);

        return view;
    }

    private void setupViewPager() {
        offerList = new ArrayList<>();
        offerList.add(R.drawable.jsi);
        offerList.add(R.drawable.jse1);
        offerList.add(R.drawable.jse2);
        HomeViewPagerAdapter viewPagerAdapter = new HomeViewPagerAdapter(context,offerList);
        viewPager.setAdapter(viewPagerAdapter);
        addBottomDots(0);
    }

    private void addBottomDots(int currentPage) {
        // Clear existing dots
        lnrlyt.removeAllViews();

        // Check if the offerList is not empty and currentPage is within bounds
        if (offerList != null && !offerList.isEmpty() && currentPage >= 0 && currentPage < offerList.size()) {
            TextView[] mTxtDot = new TextView[offerList.size()];

            // Iterate through each item in the offerList
            for (int i = 0; i < offerList.size(); i++) {
                mTxtDot[i] = new TextView(context);
                mTxtDot[i].setText(Html.fromHtml("&#8226;"));
                mTxtDot[i].setTextSize(35);
                mTxtDot[i].setTextColor(getResources().getColor(R.color.grey_300));
                lnrlyt.addView(mTxtDot[i]);
            }

            // Set the color of the dot at the currentPage index
            mTxtDot[currentPage].setTextColor(getResources().getColor(R.color.grey_400));
        } else {
            Log.e(TAG, "offerList is empty or currentPage is out of bounds.");
        }
    }



    @Override
    public void onDetach(){
        super.onDetach();
        timer.cancel();
    }


}