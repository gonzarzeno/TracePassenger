package com.tracepassenger.domain;

import com.orm.SugarRecord;



public class PassengerReading extends SugarRecord<PassengerReading> {

    private int PassengerId;
    private int ActivityId;
    private String Type;
    private String ReadingDate;
    private int State;

    public PassengerReading(){}

    public int getPassengerId() {
        return PassengerId;
    }

    public void setPassengerId(int passengerId) {
        PassengerId = passengerId;
    }

    public int getActivityId() {
        return ActivityId;
    }

    public void setActivityId(int activityId) {
        ActivityId = activityId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getReadingDate() {
        return ReadingDate;
    }

    public void setReadingDate(String readingDate) {
        ReadingDate = readingDate;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
