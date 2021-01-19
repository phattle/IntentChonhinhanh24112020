package com.example.intentchonhinhanh24112020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HighScoreActivity extends AppCompatActivity {

    RecyclerView mRcvUser;
    List<User> mArrUsers;
    UserAdapter mUserAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
        mRcvUser = findViewById(R.id.recycleHighScore);
        mArrUsers = new ArrayList<>();

        mArrUsers.add(new User("saddddddsaddddddddddđsssssssssss",10));
        mArrUsers.add(new User("saddddddsaddddddddddđssssssssssss",10));
        mArrUsers.add(new User("saddddddsaddddddddddđsssssssss",10));
        mArrUsers.add(new User("saddddddsaddddddddddđssssssssss",10));
        mArrUsers.add(new User("saddddddsaddddddddddđsssssssssss",10));
        mArrUsers.add(new User("saddddddsaddddddddddđsssssssss",10));
        mArrUsers.add(new User("saddddddsaddddddddddđsssssssssss",10));


        mUserAdapter = new UserAdapter(mArrUsers);
        mRcvUser.setAdapter(mUserAdapter);
    }
}