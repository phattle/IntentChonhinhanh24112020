package com.example.intentchonhinhanh24112020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    Button mBtnHighScoreScreen,mBtnPlayGamesScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnHighScoreScreen = findViewById(R.id.buttonHighScoreScreen);
        mBtnPlayGamesScreen = findViewById(R.id.buttonPlayGameScreen);

        mBtnPlayGamesScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PlayGameActivity.class);
                startActivity(intent);
            }
        });
        mBtnHighScoreScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HighScoreActivity.class);
                startActivity(intent);
            }
        });
        ArrayList<User> users = AppSharePreference.getInstance(this).getInfoUser();
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getScore() - o2.getScore() ;
            }
        });
        for (int i = 0; i <users.size() ; i++) {
            Log.d("BBB",users.get(i).getName());
            Log.d("BBB",users.get(i).getScore() + "");
        }
    }
//    A > b => a - b >0 ( tang dan)
//    a < b => b - a <0 (giam dan)
}