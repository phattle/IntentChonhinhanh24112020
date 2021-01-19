package com.example.intentchonhinhanh24112020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayGameActivity extends AppCompatActivity {

    TextView mTvScore,mTvTime;
    ImageView mImgReal,mImgPick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        mTvScore = findViewById(R.id.textViewScore);
        mTvTime = findViewById(R.id.textViewTime);
        mImgReal = findViewById(R.id.imageViewImageReal);
        mImgPick = findViewById(R.id.imageViewImagePick);

        mImgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayGameActivity.this,ListImageActivity.class);
                startActivity(intent);
            }
        });
    }
}