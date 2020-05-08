package com.kareh.ewraapp.ui.shop;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.ShopItem;
import com.kareh.ewraapp.ui.adapter.ShopFragmentAdapter;

import java.util.ArrayList;


public class ShopFragment extends Fragment {


    public ShopFragment() {
    }

    public static ShopFragment newInstance() {
        return new ShopFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_shop, container, false);
        ShopViewModel viewModel = ViewModelProviders.of(this).get(ShopViewModel.class);
        ArrayList<ShopItem> shopItems= viewModel.shopArrayList;
        RecyclerView recyclerView= rootView.findViewById(R.id.rv_shopFragment);
        ShopFragmentAdapter shopFragmentAdapter = new ShopFragmentAdapter(shopItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(shopFragmentAdapter);
        return rootView;


    }


}
