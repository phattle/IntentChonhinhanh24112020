package com.example.intentchonhinhanh24112020;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AppDialog {
    private AppDialog(){

    }
    public static void showDialogTotalScore(Context context, OnListenerDialogTotalScore onListenerDialogTotalScore){
        Dialog dialog = new Dialog(context);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dialog_total_score,null, false);
        dialog.setContentView(view);

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
                dialog.cancel();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListenerDialogTotalScore.onExit();
                dialog.cancel();
            }
        });
        dialog.setCancelable(false);
        dialog.show();
    }
}
