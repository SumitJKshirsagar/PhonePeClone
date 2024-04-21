package com.example.phonepay.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.phonepay.R;
import com.example.phonepay.adapter.DealerAdapter;
import com.example.phonepay.adapter.OfferAdapter;
import com.example.phonepay.adapter.OfferViewPagerAdapter;
import com.example.phonepay.model.DealerModel;
import com.example.phonepay.model.OfferModel;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class OffersFragment extends Fragment {

    private Context context;
    private RecyclerView offerRv,dealerRv,dealersRvOnline;
    private DealerAdapter adapter;
    private ViewPager viewPager;
    private ArrayList<String> offerArray;
    private LinearLayout lnrlyt;
    private Timer timer;
    private int count =0;



    public OffersFragment() {
        // Required empty public constructor
    }

      @Override
      public void onAttach(@NonNull Context context){
        super.onAttach(context);
        this.context=context;

      }
    public static OffersFragment newInstance() {
        OffersFragment fragment = new OffersFragment();
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
        View view=inflater.inflate(R.layout.fragment_offers, container, false);
        initViews(view);
        setUpViewPager();
        ArrayList<DealerModel> offlineMerchantList= new ArrayList<>();
        offlineMerchantList.add(new DealerModel("Starbucks","Flat","Rs."+"39","Cashback","Valid Once per User"));
        offlineMerchantList.add(new DealerModel("McDonalds","Get Burger worth","Rs."+"69","Free","For new User"));
        offlineMerchantList.add(new DealerModel("Metro","Flat","Rs."+"19","Free","Bill payment of Rs 500"));
        offlineMerchantList.add(new DealerModel("JIO Recharge","Cashback","Rs."+"99","Wallet","On  1st Transaction"));
         adapter = new DealerAdapter(context,offlineMerchantList);
        dealerRv.setAdapter(adapter);

        ArrayList<DealerModel> onlineDealerList = new ArrayList<>();
        onlineDealerList.add(new DealerModel("Zomato","Get","20%","Cashback","Valid Twice per User"));
        onlineDealerList.add(new DealerModel("Swiggy","Get","15%","Cashback","For New User Only"));
        onlineDealerList.add(new DealerModel("Sun Cinema","Get","50%","Cashback","Book 4 Tickets "));
        onlineDealerList.add(new DealerModel("Practo","Get","70%","Cashback","Valid Twice per User"));

        adapter = new DealerAdapter(context,onlineDealerList);
        dealersRvOnline.setAdapter(adapter);


        ArrayList<OfferModel> offerList = new ArrayList<>();
        offerList.add(new OfferModel("Bill Payment","25% Cashback",R.drawable.ic_bill_green));
        offerList.add(new OfferModel("Electricity Bill","15% Cashback",R.drawable.ic_lightbulb_green));
        offerList.add(new OfferModel("Water Bill","20% Cashback",R.drawable.ic_water_green));
        OfferAdapter adapter = new OfferAdapter(context,offerList);
        offerRv.setAdapter(adapter);

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

    private void setUpViewPager() {
        offerArray = new ArrayList<>();
        offerArray.add("25% Cashback");
        offerArray.add("Free Recharge");
        offerArray.add("20% off on SBI card");
        offerArray.add("10% discount Book Flight");
        OfferViewPagerAdapter viewPagerAdapter = new OfferViewPagerAdapter(context,offerArray);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(40,0,40,20);
        viewPager.setPageMargin(20);
        addBottomDots(3);

    }

    private void addBottomDots(int currentPage) {
        TextView[] mTxtDot = new TextView[offerArray.size()];
        lnrlyt.removeAllViews();

        for (int i = 0; i < mTxtDot.length; i++) {
            mTxtDot[i] = new TextView(context);
            mTxtDot[i].setText(Html.fromHtml("&#8226;"));
            mTxtDot[i].setTextSize(35);
            mTxtDot[i].setTextColor(getResources().getColor(R.color.grey_300));
            lnrlyt.addView(mTxtDot[i]);
        }

        if (mTxtDot.length > 0) {
            mTxtDot[currentPage].setTextColor(getResources().getColor(R.color.grey_400));
        }
    }



    private void initViews(View view) {
        viewPager = view.findViewById(R.id.offer_view_pager);
        lnrlyt = view.findViewById(R.id.ln_points);
        offerRv = view.findViewById(R.id.rv_bill_pay_offers);
        dealerRv = view.findViewById(R.id.rv_offline_merchant);
        dealersRvOnline = view.findViewById(R.id.online_dealers_recycler);
       dealersRvOnline.setNestedScrollingEnabled(false);
       dealerRv.setNestedScrollingEnabled(false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        offerRv.setLayoutManager(layoutManager);
        dealerRv.setLayoutManager(new GridLayoutManager(context,3));
        dealersRvOnline.setLayoutManager(new GridLayoutManager(context,3));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        timer.cancel();
    }
}