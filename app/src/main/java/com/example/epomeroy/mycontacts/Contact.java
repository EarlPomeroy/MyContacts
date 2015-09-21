package com.example.epomeroy.mycontacts;

import java.io.Serializable;

/**
 * Created by epomeroy on 9/20/15.
 */
public class Contact implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
