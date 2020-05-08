package com.kareh.ewraapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.ShopItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ShopFragmentAdapter extends RecyclerView.Adapter<ShopFragmentAdapter.ShopViewHolder> {
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

        @Override
        public void onClick(View v) {

        }
    }
}
