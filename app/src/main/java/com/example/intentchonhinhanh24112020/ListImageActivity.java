package com.example.intentchonhinhanh24112020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.Arrays;
import java.util.Collections;

public class ListImageActivity extends AppCompatActivity {

    TableLayout mTableLayout;
    double mRow = 0;
    int mColumn = 3;
    String [] mArrAnimals;
    int mPosition = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        mTableLayout = findViewById(R.id.tableLayoutListImage);

        mArrAnimals = getResources().getStringArray(R.array.arrAnimals);
        Collections.shuffle(Arrays.asList(mArrAnimals));

        // Task1 : Gan hinh vao vi tri
        // Task2 : Neu khong du 18 tam thi hien thi the nao
        mRow = Math.ceil( (double) mArrAnimals.length / mColumn);

        for (int i = 0 ; i < mRow ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 0 ; y < mColumn ; y++){
                mPosition = (mColumn * i) + y ;
                if (mPosition < mArrAnimals.length){
                    ImageView imageView = new ImageView(this);
                    int resourcePosition = getResources().getIdentifier(mArrAnimals[mPosition], "drawable" , getPackageName());
                    imageView.setImageResource(resourcePosition);
                    tableRow.addView(imageView);
                }
            }
            mTableLayout.addView(tableRow);
        }



    }
}