package com.kareh.ewraapp.ui.mobile;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.MobileItem;

import java.util.ArrayList;

public class MobileViewModel extends ViewModel {
    MutableLiveData<ArrayList<MobileItem>> mobileLiveData;
    ArrayList<MobileItem> mobileArrayList;

    public MobileViewModel() {
        mobileLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<MobileItem>> getMobileMutableLiveData() {
        return mobileLiveData;
    }

    public void init(){
        populateList();
        mobileLiveData.setValue(mobileArrayList);
    }
    public void populateList(){
        mobileArrayList = new ArrayList<>();
        mobileArrayList.add(new MobileItem(R.drawable.mpesa,"Send to mpesa"));
        mobileArrayList.add(new MobileItem(R.drawable.airitime,"Buy Airtime"));
    }
}
