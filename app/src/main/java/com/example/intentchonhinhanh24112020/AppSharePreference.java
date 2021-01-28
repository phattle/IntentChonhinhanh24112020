package com.example.intentchonhinhanh24112020;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;

public class AppSharePreference {
    private static AppSharePreference instance = null;
    private static SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor;

    private AppSharePreference(Context context){
        sharedPreferences = context.getSharedPreferences("AppCache",Context.MODE_PRIVATE);
    }

    public static AppSharePreference getInstance(Context context){
        if (instance == null){
            instance = new AppSharePreference(context);
        }
        return instance;
    }

    public void saveScore(String name , int score){
        editor = sharedPreferences.edit();
        long timeCurrent = System.currentTimeMillis();
        editor.putString(timeCurrent +"" , name +"," + score);
        editor.apply();
    }

    public ArrayList<User> getInfoUser(){
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,String> keys = (HashMap<String, String>) sharedPreferences.getAll();
        for (String key : keys.keySet()){
            //key chinh là thời gian người lưu trữ
            String value = sharedPreferences.getString(key,"");
            String[] data = value.split(",");
            String username = data[0];
            String score = data[1];
            users.add(new User(username,Integer.parseInt(score)));
        }
        return  users;
    }



}
