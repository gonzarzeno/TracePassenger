package com.tracepassenger.domain;

import com.orm.SugarRecord;

public class Activity extends SugarRecord<Activity> {

    private String Name;
    private int State;

    public Activity(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
