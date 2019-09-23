package com.app.zozocar.model;

import java.io.Serializable;
import java.util.Date;

public class Model implements Serializable {
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    Date date;
}
