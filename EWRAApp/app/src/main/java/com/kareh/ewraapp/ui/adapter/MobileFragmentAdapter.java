package com.kareh.ewraapp.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kareh.ewraapp.R;
import com.kareh.ewraapp.models.MobileItem;
import com.kareh.ewraapp.ui.BuyAirtime;
import com.kareh.ewraapp.ui.SendToMpesa;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MobileFragmentAdapter extends RecyclerView.Adapter<MobileFragmentAdapter.MobileViewHolder> {
    private ArrayList<MobileItem> items;

    public MobileFragmentAdapter(ArrayList<MobileItem> itemArrayList) {
        items = itemArrayList;

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
            mobileImage = itemView.findViewById(R.id.mobile_card_image);
            mobileText = itemView.findViewById(R.id.mobile_card_text);
            itemView.setOnClickListener(this);
        }

        @SuppressLint("InflateParams")
        @Override
        public void onClick(View v) {
            int mPosition = getAdapterPosition();
            MobileItem item = items.get(mPosition);
            if (item.getCardText().equals("Send to mpesa")){
            Intent mpesa_intent=new Intent(v.getContext(), SendToMpesa.class);
            v.getContext().startActivity(mpesa_intent);}
            else if(item.getCardText().equals("Buy Airtime")){
                Intent airtime_intent=new Intent(v.getContext(), BuyAirtime.class);
                v.getContext().startActivity(airtime_intent);
            }

            /*AlertDialog.Builder alertDialog = new AlertDialog.Builder(v.getContext());
            if (item.getCardText().equals("Send to mpesa")) {
                View layout = LayoutInflater.from(v.getContext()).inflate(R.layout.layout_send_money, null);

                //TODO: Uncomment lines when you need them. Otherwise app crashes
                // If app crashes after uncommenting and after use, try putting them inside lambda function
           //    final EditText etPhoneNumber = (EditText)layout.findViewById(R.id.et_phone_number);
            //  final int phoneNumber = Integer.parseInt(etPhoneNumber.getText().toString());

             //final EditText etSendAmount = (EditText)layout.findViewById(R.id.et_send_amount);
              // final int sendAmount = Integer.parseInt(etSendAmount.getText().toString());

                alertDialog.setTitle("Send to MPESA");
                alertDialog.setView(layout);
             //   final EditText etPhoneNumber = (EditText)layout.findViewById(R.id.et_phone_number);
               // final int phoneNumber = Integer.parseInt(etPhoneNumber.getText().toString());

               // final EditText etSendAmount = (EditText)layout.findViewById(R.id.et_send_amount);
              //  final int sendAmount = Integer.parseInt(etSendAmount.getText().toString());

                alertDialog.setPositiveButton("Ok", ((dialog, which) -> {
                    //TODO: Perform Hover Action Here

                    final EditText etPhoneNumber = (EditText)layout.findViewById(R.id.et_phone_number);
                     final int phoneNumber = Integer.parseInt(etPhoneNumber.getText().toString());

                    final EditText etSendAmount = (EditText)layout.findViewById(R.id.et_send_amount);
                     final int sendAmount = Integer.parseInt(etSendAmount.getText().toString());
                    Toast.makeText(v.getContext(),"Working lol",Toast.LENGTH_SHORT).show();
                }));

            } else if (item.getCardText().equals("Buy Airtime")) {
                View layout = LayoutInflater.from(v.getContext()).inflate(R.layout.layout_buy_airtime, null);

                //TODO: Uncomment lines when you need them. Otherwise app crashes
                // If app crashes after uncommenting and after use, try putting them inside lambda function
//                final EditText etBuyAirtime = (EditText)layout.findViewById(R.id.et_buy_airtime);
//                final int airtimeAmount = Integer.parseInt(etBuyAirtime.getText().toString());

                alertDialog.setTitle("Buy Airtime");
                alertDialog.setView(layout);

                alertDialog.setPositiveButton("Ok", ((dialog, which) -> {
                    //TODO: Perform Hover Action Here
                    Intent i = new HoverParameters.Builder(v.getContext())
                            .request("b70e5ad1")
                            //  .extra("step_variable_name", variable_value_as_string) // Only if your action has variables
                            .buildIntent();
                   // v.getContext().startActivityForResult(i, 0);
                }));
            }
            alertDialog.show();*/
        }
    }
}
