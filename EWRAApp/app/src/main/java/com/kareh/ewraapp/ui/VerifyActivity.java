package com.kareh.ewraapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.kareh.ewraapp.R;

import java.util.concurrent.TimeUnit;

public class VerifyActivity extends AppCompatActivity {
    private String mVerificationId;
    private EditText editTextCode;
    private FirebaseAuth mAuth;
    private ProgressBar mProgressBar;
    private PhoneAuthProvider.ForceResendingToken mResendToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        mProgressBar=findViewById(R.id.progressbar);
        mAuth=FirebaseAuth.getInstance();
        editTextCode=(EditText)findViewById(R.id.txt_code);
        Intent intent=getIntent();
        String mobile=intent.getStringExtra("mobile");
        sendVerificationCode(mobile);
        findViewById(R.id.submit_code).setOnClickListener(v -> {
            String code = editTextCode.getText().toString().trim();
            if (code.isEmpty() || code.length() < 6) {
                editTextCode.setError("Enter valid code");
                editTextCode.requestFocus();
                return;
            }

            //verifying the code entered manually
            verifyVerificationCode(code);
        });


    }

    private void sendVerificationCode(String mobile) {
        mProgressBar.setVisibility(View.VISIBLE);
        
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobile,
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onVerificationCompleted(PhoneAuthCredential credential) {
            String code=credential.getSmsCode();
            if(code!=null){

                editTextCode.setText(code);
                verifyVerificationCode(code);
            }

        }


        @Override
        public void onVerificationFailed(FirebaseException e) {
            if (e instanceof FirebaseAuthInvalidCredentialsException) {
                Toast.makeText(VerifyActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

            } else if (e instanceof FirebaseTooManyRequestsException) {
                Toast.makeText(VerifyActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }


        }
        @Override
        public void onCodeSent(@NonNull String verificationId,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
            mVerificationId = verificationId;
            mResendToken = token;
        }
    };

    private void verifyVerificationCode(String code) {
        PhoneAuthCredential phoneAuthCredential=PhoneAuthProvider.getCredential(mVerificationId,code);
        signInWithPhoneAuthCredential(phoneAuthCredential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Intent intent=new Intent(VerifyActivity.this,HomeActivity.class);
                        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);


                    } else {
                        String message = "Somthing is wrong,try again!";

                        if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            message= " The verification code entered was invalid";
                        }
                        Snackbar snackbar=Snackbar.make(findViewById(R.id.parent),message,Snackbar.LENGTH_LONG);
                        snackbar.setAction("Dismiss", v -> {

                        });
                        snackbar.show();

                    }
                });


    }
}
