package com.example.epomeroy.mycontacts;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by epomeroy on 9/20/15.
 */
public class Contact implements Serializable {
    private String name;
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    public void removeEmail(String email) {
        this.emails.remove(email);
    }

    public void removeEmail(int emailIndex) {
        this.emails.remove(emailIndex);
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public void removePhoneNumber(String phoneNumber) {
        this.phoneNumbers.remove(phoneNumber);
    }

    public void removePhoneNumber(int phoneNumberIndex) {
        this.phoneNumbers.remove(phoneNumberIndex);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
