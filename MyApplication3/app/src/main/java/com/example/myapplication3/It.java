package com.example.myapplication3;

public class It {
    String name;
    String time;
    boolean checked;

    public It(String name, String time, boolean checked) {
        this.name = name;
        this.time = time;
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
