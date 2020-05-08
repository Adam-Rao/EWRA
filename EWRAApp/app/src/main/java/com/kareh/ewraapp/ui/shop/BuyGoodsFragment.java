package com.kareh.ewraapp.ui.shop;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kareh.ewraapp.R;



public class BuyGoodsFragment extends Fragment {


    public BuyGoodsFragment() {
        // Required empty public constructor
    }


    public static BuyGoodsFragment newInstance(String param1, String param2) {

        return new BuyGoodsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy_goods, container, false);
    }
}
