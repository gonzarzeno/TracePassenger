package com.tracepassenger.domain;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;



public class JourneyGroup extends SugarRecord<JourneyGroup>{

    private String GroupName;
    private String CoordinatorName;
    private String Identifier;
    private int State;
    @Ignore
    private boolean isSelected;

    public JourneyGroup(){}

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getCoordinatorName() {
        return CoordinatorName;
    }

    public void setCoordinatorName(String coordinatorName) {
        CoordinatorName = coordinatorName;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String identifier) {
        Identifier = identifier;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
