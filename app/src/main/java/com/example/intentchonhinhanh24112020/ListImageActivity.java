package com.example.intentchonhinhanh24112020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class ListImageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MyCountDown.getInstance().stopTimer();
            }
        },1000);
    }
}