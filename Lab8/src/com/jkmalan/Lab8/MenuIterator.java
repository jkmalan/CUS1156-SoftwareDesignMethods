package com.jkmalan.Lab8;

/**
 * Represents a custom MenuIterator
 *
 * @author jkmalan (aka John Malandrakis)
 */
public interface MenuIterator {

    /**
     * Shifts index to next value
     *
     * @return The MenuItem value
     */
    public MenuItem next();

    /**
     * Checks for a next value
     *
     * @return If value exists, return true, else return false
     */
    public boolean hasNext();

    /**
     * Removes the value at the current index
     */
    public void remove();

}
