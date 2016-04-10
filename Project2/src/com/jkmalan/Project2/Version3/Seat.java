package com.jkmalan.Project2.Version3;

/**
 * Represents a Seat on a Flight
 *
 * @author jkmalan (aka John Malandrakis)
 * @author Kuba Gasiorowski
 */
public class Seat implements Comparable<Seat> {

    private int number;
    private String letter;

    /**
     * Constructs a Seat object
     *
     * @param number The row number
     * @param letter The seat letter
     */
    public Seat(int number, String letter) {
        setNumber(number);
        setLetter(letter);
    }

    /**
     * Returns the number of the id
     *
     * @return The number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the set's number to the new value
     * 
     * @param number
     * 		the new seat number
     */
    public void setNumber(int number)
    {
    	this.number = number;
    }
    
    /**
     * Returns the letter of the id
     *
     * @return The letter
     */
    public String getLetter() {
        return letter;
    }

    /**
     * Sets the seat's letter to the new value
     * 
     * @param letter
     * 		the new value of letter
     */
    public void setLetter(String letter)
    {
    	this.letter = letter;
    }
    
    @Override
    public int compareTo(Seat s) {
    		
        if (s.getNumber() < number) 
            return 1;
        else if (s.getNumber() > number)
            return -1;
        else
            return s.getLetter().compareToIgnoreCase(this.getLetter());
        
    }

    @Override
    public boolean equals(Object obj) {
        
    	//Check if it's a passenger. Returns false if
    	//obj is null, too.
    	if(!(obj instanceof Seat))
    		return false;
    	
    	//For convenience
    	Seat s = (Seat) obj;

    	//Return if the two objects are the same
        return s.getNumber() == number && 
        	   s.getLetter().equals(letter);
     
        
    }
}
