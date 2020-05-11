package com.kareh.ewraapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.hover.sdk.actions.HoverAction;
import com.hover.sdk.api.Hover;
import com.kareh.ewraapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnLogin;
    private EditText phone_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Hover.initialize(this);
        phone_edit_text=(EditText) findViewById(R.id.txt_phone_number);
        btnLogin=(Button)findViewById(R.id.login);
        btnLogin.setOnClickListener(v -> {
            String mobileNumber=phone_edit_text.getText().toString().trim();
            if(mobileNumber.isEmpty() || mobileNumber.length()<10){
                phone_edit_text.setError("Valid mobile number required");
                phone_edit_text.requestFocus();
                return;
            }
            Intent intent=new Intent(MainActivity.this,VerifyActivity.class);
            intent.putExtra("mobile",mobileNumber);
            startActivity(intent);
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()!=null){
            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        //FirebaseAuth.getInstance().getAccessToken(true);
    }

}
