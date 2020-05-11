package com.kareh.ewraapp.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hover.sdk.actions.HoverAction;
import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;
import com.kareh.ewraapp.R;

import java.util.ArrayList;

public class BillActivity extends AppCompatActivity implements Hover.DownloadListener {
    private final String TAG = "BillActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bill);
        EditText businessNumber_etx=findViewById(R.id.business_number);
        EditText accountNumber_etx=findViewById(R.id.bill_account_number);
        EditText amount_etx=findViewById(R.id.bill_amount);
        Button submit=findViewById(R.id.bill_submit);
        String businessNumber=businessNumber_etx.getText().toString();
        String accountNumber=accountNumber_etx.getText().toString();
        String amount=amount_etx.getText().toString();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new HoverParameters.Builder(BillActivity.this)
                        .request("20a4d131")
                        .extra("businessNo",businessNumber)
                        .extra("accountNo",accountNumber)
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
    public void onError(String s) {

    }

    @Override
    public void onSuccess(ArrayList<HoverAction> arrayList) {

    }
}
