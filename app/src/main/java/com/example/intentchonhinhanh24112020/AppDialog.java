package com.example.intentchonhinhanh24112020;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppDialog {
    private  static Dialog mDialog = null;
    private AppDialog(){

    }
    public static void showDialogTotalScore(Context context, OnListenerDialogTotalScore onListenerDialogTotalScore){
        if (mDialog == null){
            mDialog = new Dialog(context);
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.dialog_total_score,null, false);
            mDialog.setContentView(view);

            Button btnSave = view.findViewById(R.id.buttonSave);
            Button btnExit = view.findViewById(R.id.buttonExit);
            EditText edtName = view.findViewById(R.id.edittextName);

            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = edtName.getText().toString();
                    if (name.isEmpty()){
                        Toast.makeText(context, "Bạn chưa nhập tên", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    onListenerDialogTotalScore.onSave(name);
                    mDialog.cancel();
                }
            });

            btnExit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onListenerDialogTotalScore.onExit();
                    mDialog.cancel();
                }
            });
            mDialog.setCancelable(false);
            mDialog.show();
        }else{
            mDialog.cancel();
            mDialog = null;
            showDialogTotalScore(context,onListenerDialogTotalScore);
        }

    }
}
