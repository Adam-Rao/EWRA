package com.kareh.ewraapp.ui.adapter;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.ShopItem;
import com.kareh.ewraapp.ui.BillActivity;
import com.kareh.ewraapp.ui.BuyGoods;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShopFragmentAdapter extends RecyclerView.Adapter<ShopFragmentAdapter.ShopViewHolder> {
    private static final String TAG = "ShopFragmentAdapter";
    private ArrayList<ShopItem> items;
    public ShopFragmentAdapter(ArrayList<ShopItem> items){
        this.items=items;
    }
    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_rv_item, parent, false);
        return new ShopViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        ShopItem item = items.get(position);
        holder.shopText.setText(item.getCardText());
        Picasso.get().load(item.getImageResouce()).into(holder.shopImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ShopViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView shopText;
        public final ImageView shopImage;
        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);
            shopImage = itemView.findViewById(R.id.mobile_card_image) ;
            shopText = itemView.findViewById(R.id.mobile_card_text);
            itemView.setOnClickListener(this);
        }

        @SuppressLint("InflateParams")
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick: Recyclerview onclick works");
            int itemPosition = getAdapterPosition();
            ShopItem item = items.get(itemPosition);
            if (item.getCardText().equals("Buy Goods With Mpesa")){
                Intent buygoods_intent=new Intent(v.getContext(), BuyGoods.class);
                v.getContext().startActivity(buygoods_intent);}
            else if(item.getCardText().equals("PayBill")){
                Intent paybill_intent=new Intent(v.getContext(), BillActivity.class);
                v.getContext().startActivity(paybill_intent);
            }
           /* AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
            if (item.getCardText().equals(v.getContext().getResources().getString(R.string.buy_goods_with_mpesa))) {
                View layout = LayoutInflater.from(v.getContext()).inflate(R.layout.layout_buy_goods, null);
                alertDialog.setTitle(v.getContext().getResources().getString(R.string.buy_goods_with_mpesa));
                alertDialog.setView(layout);
                alertDialog.setPositiveButton("Ok", (dialog, which) -> {
                    // TODO: Perform buy goods hover action here
                    final EditText etTillNumber = (EditText)layout.findViewById(R.id.et_till_number);
                    final EditText etTotalAmount = (EditText)layout.findViewById(R.id.et_total_amount);

                    final int tillNumber = Integer.parseInt(etTillNumber.getText().toString());
                    final int totalAmount = Integer.parseInt(etTotalAmount.getText().toString());

                    Log.d(TAG, "onClick: It works");
                });
                
            } else if (item.getCardText().equals("PayBill")) {
                View layout = LayoutInflater.from(v.getContext()).inflate(R.layout.layout_pay_bill, null);
                alertDialog.setTitle("PayBill");
                alertDialog.setView(layout);
                alertDialog.setPositiveButton("Ok", (dialog, which) -> {
                    // TODO: Perform paybill hover action here
                    final EditText etAccountNumber = (EditText)layout.findViewById(R.id.et_account_number);
                    final EditText etTotalAmount = (EditText)layout.findViewById(R.id.et_total_amount);

                    final int accountNumber = Integer.parseInt(etAccountNumber.getText().toString());
                    final int totalAmount = Integer.parseInt(etTotalAmount.getText().toString());

                    Log.d(TAG, "onClick: It works");
                });
            }
            alertDialog.show();*/
        }
    }
}
