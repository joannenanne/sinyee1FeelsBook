package com.example.sinyee1_feelsbook0;

import android.app.Application;

import java.util.Date;

public class Attribute extends Application {
    private String currentdate;
    private String emotion;
    private String comment;

    public String getCurrentDate() {
        Date date = new Date(System.currentTimeMillis());
        currentdate = date.toString();
        return currentdate;
    }

    public void setCurrentDate(Date date) {
        currentdate = date.toString();
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emo) {
        emotion = emo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String c) {
        comment = c;
    }
}
