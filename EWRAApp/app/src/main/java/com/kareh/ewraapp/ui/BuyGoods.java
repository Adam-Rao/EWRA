package com.kareh.ewraapp.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hover.sdk.actions.HoverAction;
import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;
import com.kareh.ewraapp.R;

import java.util.ArrayList;

public class BuyGoods extends AppCompatActivity implements Hover.DownloadListener{
     private final String TAG="BuyGoods";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_buy_goods);
        EditText tillNo_etx=findViewById(R.id.till_number);
        EditText tillAmount_etx=findViewById(R.id.till_amount);
        String tillNo=tillNo_etx.getText().toString();
        String amount=tillAmount_etx.getText().toString();
        Button tillSubmit=findViewById(R.id.till_submit);
        tillSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new HoverParameters.Builder(BuyGoods.this)
                        .request("322b4277")
                        .extra("tillNo",tillNo)
                        .extra("amount",amount)
                        .buildIntent();
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            String[] sessionTextArr = data.getStringArrayExtra("session_messages");
            String uuid = data.getStringExtra("uuid");
        } else if (requestCode == 0 && resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Error: " + data.getStringExtra("error"), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, "Error while attempting to download actions, see logcat for error", Toast.LENGTH_LONG).show();
        Log.e(TAG, "Error: " + message);
    }

    @Override
    public void onSuccess(ArrayList<HoverAction> actions) {
        Toast.makeText(this, "Successfully downloaded " + actions.size() + " actions", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Successfully downloaded " + actions.size() + " actions");
    }
}
