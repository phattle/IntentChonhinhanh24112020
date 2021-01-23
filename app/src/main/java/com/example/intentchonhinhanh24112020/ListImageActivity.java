package com.example.intentchonhinhanh24112020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ListImageActivity extends AppCompatActivity {

    TableLayout mTableLayout;
    int mRow = 6;
    int mColumn = 3;
    String [] mArrAnimals;
    int mPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        mTableLayout = findViewById(R.id.tableLayoutListImage);

        mArrAnimals = getResources().getStringArray(R.array.arrAnimals);

        // Task1 : Gan hinh vao vi tri
        // Task2 : Neu khong du 18 tam thi hien thi the nao
        for (int i = 0 ; i < mRow ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 0 ; y < mColumn ; y++){
                ImageView imageView = new ImageView(this);
                int resourcePosition = getResources().getIdentifier(mArrAnimals[mPosition++], "drawable" , getPackageName());
                imageView.setImageResource(resourcePosition);
                tableRow.addView(imageView);
            }
            mTableLayout.addView(tableRow);
        }



    }
}