package com.kareh.ewraapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.hover.sdk.actions.HoverAction;
import com.hover.sdk.api.Hover;
import com.hover.sdk.api.HoverParameters;
import com.kareh.ewraapp.R;

import java.util.ArrayList;

public class BuyAirtime extends AppCompatActivity implements Hover.DownloadListener{
    private final String TAG = "BuyAirtime";
    private String mPhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_airtime);

        RadioGroup numbers=findViewById(R.id.rg_airtime);
        int selectId=numbers.getCheckedRadioButtonId();
        EditText phone_number_etx=findViewById(R.id.airtime_phone_number);
        EditText amount_etx=findViewById(R.id.airtime_amount);
        RadioButton myNumber=(RadioButton) findViewById(selectId) ;

            mPhoneNo = phone_number_etx.getText().toString();

        String amount=amount_etx.getText().toString();
       // RadioButton otherNumber=(RadioButton) findViewById(R.id.rbt_otherNumber);

        Button btnAirtime=(Button)findViewById(R.id.submit_airtime);
        btnAirtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new HoverParameters.Builder(BuyAirtime.this)
                        .request("7a291448")
                        .extra("phoneNo",mPhoneNo)
                       .extra("amount",amount)
                        .buildIntent();
                startActivityForResult(i, 0);
            }
        });

    }
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
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
