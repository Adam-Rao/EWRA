package com.kareh.ewraapp.ui.shop;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.ShopItem;

import java.util.ArrayList;

public class ShopViewModel extends ViewModel {
    MutableLiveData<ArrayList<ShopItem>> shopLiveData;
    ArrayList<ShopItem> shopArrayList;


    public ShopViewModel() {
        shopLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<ShopItem>> getShopMutableLiveData() {
        return shopLiveData;
    }

    public void init(){
        populateList();
        shopLiveData.setValue(shopArrayList);
    }

    public void populateList(){
        shopArrayList = new ArrayList<>();
        shopArrayList.add(new ShopItem(R.drawable.bill_payment,"Buy Goods With Mpesa"));
        shopArrayList.add(new ShopItem(R.drawable.paybill,"PayBill"));
    }
}
