package com.example.epomeroy.mycontacts;

import java.util.ArrayList;

/**
 * Created by epomeroy on 9/27/15.
 */
public class ContactList extends ArrayList<Contact> {
    private static ContactList instance = null;

    private ContactList() {};

    public static ContactList getInstance() {
        if (instance == null) {
            instance = new ContactList();
        }

        return instance;
    }
}
