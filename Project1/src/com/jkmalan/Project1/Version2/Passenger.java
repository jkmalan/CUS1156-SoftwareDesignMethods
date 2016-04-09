package com.jkmalan.Project1.Version2;

/**
 * Represents a Passenger
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class Passenger {

    private String firstName;
    private String lastName;
    private String nationality;

    /**
     * Constructs a Passenger object
     *
     * @param firstName The passenger first name
     * @param lastName The passenger last name
     * @param nationality The passenger nationality
     */
    public Passenger(String firstName, String lastName, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    /**
     * Returns the passenger first name
     *
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the passenger first name
     *
     * @param firstName The first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the passenger last name
     *
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the passenger last name
     *
     * @param lastName The last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the passenger nationality
     *
     * @return The nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the passenger nationality
     *
     * @param nationality The nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
