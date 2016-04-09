package com.jkmalan.Lab2.Part2;

/**
 * Represents an assignment or exam
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class GradeRecord {

    private String name;
    private double grade;

    public GradeRecord(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    /**
     * Returns the assignment name
     *
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the assignment name
     *
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the assignment grade
     *
     * @return The grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Sets the assignment grade
     *
     * @param grade The grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    }

}
