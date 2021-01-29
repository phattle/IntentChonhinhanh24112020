package com.example.intentchonhinhanh24112020;

import androidx.annotation.Nullable;
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

        mTvScore = findViewById(R.id.textViewScore);
        mTvTime = findViewById(R.id.textViewTime);
        mImgReal = findViewById(R.id.imageViewImageReal);
        mImgPick = findViewById(R.id.imageViewImagePick);

        mMyCountDown = MyCountDown.getInstance();
        mMyCountDown.startTimer(10000, 1000);

        mMyCountDown.getTimeCurrent(new OnListenerTimer() {
            @Override
            public void onTick(long timeCurrent) {
                Toast.makeText(PlayGameActivity.this, timeCurrent+ "", Toast.LENGTH_SHORT).show();
            }
        });

        mImgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayGameActivity.this,ListImageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //các truong hop
        // 1 : co du lieu hinh
        // 2: Het thoi gian
        // 3: khong chon hinh
        if (requestCode == 123 && resultCode == RESULT_OK){

        }

    }
}