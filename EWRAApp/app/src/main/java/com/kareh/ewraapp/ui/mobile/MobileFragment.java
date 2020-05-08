package com.kareh.ewraapp.ui.mobile;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.MobileItem;
import com.kareh.ewraapp.ui.adapter.MobileFragmentAdapter;

import java.util.ArrayList;


public class MobileFragment extends Fragment {


    private MobileViewModel mViewModel;

    public MobileFragment() {

        }
    public static MobileFragment newInstance() {
        return new MobileFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_mobile, container, false);
        mViewModel = ViewModelProviders.of(this).get(MobileViewModel.class);
        ArrayList<MobileItem> mobileItems=mViewModel.mobileArrayList;
        RecyclerView recyclerView= rootView.findViewById(R.id.rv_mobileFragment);
        MobileFragmentAdapter mobileFragmentAdapter = new MobileFragmentAdapter(mobileItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerView.setAdapter(mobileFragmentAdapter);
        return rootView;
    }

}
