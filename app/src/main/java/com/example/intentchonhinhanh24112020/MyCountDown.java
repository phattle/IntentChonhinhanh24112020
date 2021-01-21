package com.example.intentchonhinhanh24112020;

import android.os.CountDownTimer;

public class MyCountDown {
    private static MyCountDown instance = null;
    private static CountDownTimer mCountDownTimer = null;
    private boolean isRunning = false;
    private OnListenerTimer mOnListenerTimer = null;

    private MyCountDown(){

    }
    public static MyCountDown getInstance(){
        if (instance == null){
            instance = new MyCountDown();
        }
        return instance;
    }

    public void startTimer(long totalTime , long intervalTime){
        if (isRunning){
            mCountDownTimer.cancel();
        }
        mCountDownTimer = new CountDownTimer(totalTime , intervalTime) {
            @Override
            public void onTick(long millisUntilFinished) {
                isRunning = true;
                if (millisUntilFinished / 1000 > 0){
                    if (mOnListenerTimer != null){
                        mOnListenerTimer.onTick(millisUntilFinished);
                    }
                }

            }

            @Override
            public void onFinish() {
                isRunning = false;
            }
        };
        mCountDownTimer.start();
    }
    public void getTimeCurrent(OnListenerTimer onListenerTimer){
        mOnListenerTimer = onListenerTimer;
    }

    public void stopTimer(){
        if (mCountDownTimer != null){
            if (isRunning){
                mCountDownTimer.cancel();
            }
        }
    }
}
