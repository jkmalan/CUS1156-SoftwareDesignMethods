package com.jkmalan.Project2.Version3;

/**
 * Represents a Seat on a Flight
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class Seat implements Comparable {

    private int number;
    private String letter;

    /**
     * Constructs a Seat object
     *
     * @param number The row number
     * @param letter The seat letter
     */
    public Seat(int number, String letter) {
        this.number = number;
        this.letter = letter;
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
     * Returns the letter of the id
     *
     * @return The letter
     */
    public String getLetter() {
        return letter;
    }

    @Override
    public int compareTo(Object o) {
        Seat s = (Seat) o;

        if (s.getNumber() < number) {
            return 1;
        } else if (s.getNumber() > number) {
            return -1;
        } else {
            if (s.getLetter().charAt(0) < letter.charAt(0)) {
                return 1;
            } else if (s.getLetter().charAt(0) > letter.charAt(0)) {
                return -1;
            } else {
                return 0;
            }
        }
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
