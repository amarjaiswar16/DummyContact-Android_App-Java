package com.amrdroid.dummycontact;

public class ContactModel {
    int personImg;
    String personName;
    String contactNo;
    public ContactModel(int personImg,String personName,String contactNo) {
        this.personImg = personImg;
        this.personName = personName;
        this.contactNo = contactNo;
    }
    public ContactModel(String personName,String contactNo) {
        this.personName = personName;
        this.contactNo = contactNo;
    }
}
