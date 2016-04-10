package com.jkmalan.Project2.Version3;

/**
 * Represents a Passenger on a Flight
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
     * @param firstName The passenger's first name
     * @param lastName The passenger's last name
     * @param nationality The passenger's nationality
     */
    public Passenger(String firstName, String lastName, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    /**
     * Returns the passenger's first name
     *
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the passenger's first name
     *
     * @param firstName The new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the passenger's last name
     *
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the passenger's last name
     *
     * @param lastName The new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the passenger's nationality
     *
     * @return The nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the passenger's nationality
     *
     * @param nationality The new nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object obj) {

    	//Check if it's a passenger. Returns false if
    	//obj is null, too.
        if(!(obj instanceof Passenger))
        	return false;
        
        //For convenience
        Passenger p = (Passenger) obj;
        
        //Return if the two objects are the same
        return 	p.getFirstName().equals(firstName) && 
        		p.getLastName().equals(lastName) && 
        		p.getNationality().equals(nationality);
            
    }
}
