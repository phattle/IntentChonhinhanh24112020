package com.example.intentchonhinhanh24112020;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayGameActivity extends AppCompatActivity {

    TextView mTvScore,mTvTime;
    ImageView mImgReal,mImgPick;
    MyCountDown mMyCountDown;
    String[] mArrAnimals;
    int mResourceImgRandom = 0;
    int mResourceImgPick = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);
        init();
        mapView();
        event();
    }

    private void mapView() {
        // Xử lý random
        int index = new Random().nextInt(mArrAnimals.length);
        // Lấy dữ liệu từ tên file
        mResourceImgRandom = getResources().getIdentifier(mArrAnimals[index],"drawable",getPackageName());
        mImgReal.setImageResource(mResourceImgRandom);
    }

    private void event() {
        // Chạy thời gian để bắt đầu chơi
        mMyCountDown.startTimer(4000, 1000);

        // Bắt sự kiện chuyển qua màn hình chọn danh sách hình
        mImgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayGameActivity.this,ListImageActivity.class);
                // Sử dụng hàm startActivityForResult khi muốn nhận kết quả từ màn hình ListImageActivity
                // Request Code : là key dùng để kiểm tra dữ liệu mà màn hình ListImageActivity trả về
                startActivityForResult(intent,123);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Kiểm tra thời gian đếm ngược
        mMyCountDown.getTimeCurrent(new OnListenerTimer() {
            @Override
            public void onTick(long timeCurrent) {
                mTvTime.setText("Time : "  + timeCurrent / 1000);
            }
        });
    }

    private void init() {
        mTvScore = findViewById(R.id.textViewScore);
        mTvTime = findViewById(R.id.textViewTime);
        mImgReal = findViewById(R.id.imageViewImageReal);
        mImgPick = findViewById(R.id.imageViewImagePick);

        // Truyền giá trị từ file string array
        mArrAnimals = getResources().getStringArray(R.array.arrAnimals);

        mMyCountDown = MyCountDown.getInstance();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Cac truong hop
        // 1 : Co du lieu hinh
        // 2 : Het thoi gian
        // 3 : Khong chon hinh
        if (requestCode == 123 && resultCode == RESULT_OK){
            mResourceImgPick = data.getIntExtra("resourceimage",-1);
            mImgPick.setImageResource(mResourceImgPick);
        }
        if (requestCode == 123 && resultCode == RESULT_CANCELED){
            if (data != null){
                mResourceImgPick = data.getIntExtra("resourceimage",-1);
                mTvTime.setText("Time : "  + 0);
                Toast.makeText(this, "Het gio!!", Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(this, "Ban chua chon hinh", Toast.LENGTH_SHORT).show();
            }
        }
    }
}