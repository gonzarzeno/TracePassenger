package com.tracepassenger.domain;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

public class Passenger extends SugarRecord<Passenger> {

    private String NfcTag;
    private String Name;
    private String Surname;
    private String Document;
    private String Direction;
    private String Telephone;
    private String MobilePhone;
    private String ContactName;
    private String ContactPhone;
    private String ContactRelation;
    private String MedicalSociety;
    private String EmergencyName;
    private String EmergencyPhone;
    private String Medicines;
    private String Diseases;
    private String Observations;
    private int GroupId;
    private int Synchronized;
    private int State;
    @Ignore
    private boolean isSelected;

    public Passenger(){}

    public Passenger(String name, String surname)
    {
        this.Name = name;
        this.Surname = surname;
        this.GroupId = 0;
        this.Synchronized = 1;
        this.State = 1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactPhone() {
        return ContactPhone;
    }

    public void setContactPhone(String contactPhone) {
        ContactPhone = contactPhone;
    }

    public String getContactRelation() {
        return ContactRelation;
    }

    public void setContactRelation(String contactRelation) {
        ContactRelation = contactRelation;
    }

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public String getMedicalSociety() {
        return MedicalSociety;
    }

    public void setMedicalSociety(String medicalSociety) {
        MedicalSociety = medicalSociety;
    }

    public String getEmergencyName() {
        return EmergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        EmergencyName = emergencyName;
    }

    public String getEmergencyPhone() {
        return EmergencyPhone;
    }

    public void setEmergencyPhone(String emergencyPhone) {
        EmergencyPhone = emergencyPhone;
    }

    public String getMedicines() {
        return Medicines;
    }

    public void setMedicines(String medicines) {
        Medicines = medicines;
    }

    public String getDiseases() {
        return Diseases;
    }

    public void setDiseases(String diseases) {
        Diseases = diseases;
    }

    public String getObservations() {
        return Observations;
    }

    public void setObservations(String observations) {
        Observations = observations;
    }

    public int getSynchronized() {
        return Synchronized;
    }

    public void setSynchronized(int aSynchronized) {
        Synchronized = aSynchronized;
    }

    public String getNfcTag() {
        return NfcTag;
    }

    public void setNfcTag(String nfcTag) {
        NfcTag = nfcTag;
    }

    public int getGroupId() {
        return GroupId;
    }

    public void setGroupId(int groupId) {
        GroupId = groupId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
