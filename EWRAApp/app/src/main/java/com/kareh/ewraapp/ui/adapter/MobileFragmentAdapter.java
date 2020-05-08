package com.kareh.ewraapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.MobileItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MobileFragmentAdapter extends RecyclerView.Adapter<MobileFragmentAdapter.MobileViewHolder> {
    private ArrayList<MobileItem> items;
    public MobileFragmentAdapter(ArrayList<MobileItem> itemArrayList){
        items=itemArrayList;

    }
    @NonNull
    @Override
    public MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mobile_rv_item, parent, false);
        return new MobileViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MobileViewHolder holder, int position) {
        MobileItem item = items.get(position);
        holder.mobileText.setText(item.getCardText());
        Picasso.get().load(item.getImageResouce()).into(holder.mobileImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MobileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mobileText;
        public final ImageView mobileImage;
        public MobileViewHolder(@NonNull View itemView) {
            super(itemView);
            mobileImage = itemView.findViewById(R.id.mobile_card_image) ;
            mobileText = itemView.findViewById(R.id.mobile_card_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getAdapterPosition();




        }
    }
}
