package com.tracepassenger.domain;

import com.orm.SugarRecord;

public class Journey extends SugarRecord<Journey> {

    private String Name;
    private String Destination;
    private String StartDate;
    private String EndDate;
    private int State;


    public Journey(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }
}
