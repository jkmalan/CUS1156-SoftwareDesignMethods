package com.jkmalan.Project1.Version1b;

/**
* This holds the passenger object
**/
public class Passenger {

    private String firstName, lastName, nationality;
    /**
    * Constructor to hold the name and nationality
    **/
    public Passenger(String firstName, String lastName, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }
    /**
    * sets the firstname
    **/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
    * returns the first name
    **/
    public String getFirstName() {
        return firstName;
    }
    /**
    * sets the last name
    **/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
    * gets the last name
    **/
    public String getLastName() {
        return lastName;
    }
    /**
    * sets the last name
    **/
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    /**
    * gets the nationality
    **/
    public String getNationality() {
        return nationality;
    }

}
