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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        mTableLayout = findViewById(R.id.tableLayoutListImage);

        for (int i = 0 ; i < mRow ; i++){
            TableRow tableRow = new TableRow(this);
            for (int y = 0 ; y < mColumn ; y++){
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.bo);
                tableRow.addView(imageView);
            }
            mTableLayout.addView(tableRow);
        }



    }
}