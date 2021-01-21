package com.example.intentchonhinhanh24112020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayGameActivity extends AppCompatActivity {

    TextView mTvScore,mTvTime;
    ImageView mImgReal,mImgPick;
    MyCountDown mMyCountDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        init();
        event();

    }

    private void event() {
        // Chạy thời gian để bắt đầu chơi
        mMyCountDown.startTimer(4000, 1000);

        // Kiểm tra thời gian đếm ngược
        mMyCountDown.getTimeCurrent(new OnListenerTimer() {
            @Override
            public void onTick(long timeCurrent) {
                mTvTime.setText("Time : "  + timeCurrent / 1000);
            }
        });


        // Bắt sự kiện chuyển qua màn hình chọn danh sách hình
        mImgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayGameActivity.this,ListImageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        mTvScore = findViewById(R.id.textViewScore);
        mTvTime = findViewById(R.id.textViewTime);
        mImgReal = findViewById(R.id.imageViewImageReal);
        mImgPick = findViewById(R.id.imageViewImagePick);

        mMyCountDown = MyCountDown.getInstance();
    }
}