package com.jess.wilu.remembrCall;

import java.util.Date;


public class Call {

    String name;
    Date date;
    String duration;

    public Call(Date callDate, String callDuration, String contactName) {

        this.setDate(callDate);
        this.setDuration(callDuration);
        this.setName(contactName);
    }

    public Call() {
        this.setDate(new Date(105, 1, 1));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }


}
