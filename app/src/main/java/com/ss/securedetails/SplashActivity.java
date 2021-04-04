package com.ss.securedetails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ss.securedetails.activity.HomeActivity;
import com.ss.securedetails.activity.LoginActivity;
import com.ss.securedetails.preferance.Shareprefrance;

public class SplashActivity extends AppCompatActivity {

    private Context context = SplashActivity.this;
    private String TAG = SplashActivity.class.getSimpleName();

    private Shareprefrance shareprefrance;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shareprefrance = new Shareprefrance();

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(context, LoginActivity.class));
                finish();

//                if (shareprefrance.isLOgin(context)) {
//
//                } else {
//                    Intent intent = new Intent(context, LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }

            }
        }, 3000);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}