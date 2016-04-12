package com.jkmalan.Lab9.Registration;

public class Course {

    private String name;
    private int numReg;

    public Course(String name) {
        this.name = name;
        numReg = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumReg() {
        return numReg;
    }

    public void setNumReg(int numReg) {
        this.numReg = numReg;
    }

    public void addStudent() {
        numReg++;
    }

    public void removeStudent() {
        numReg--;
    }

    public String toString() {
        return name + " enrollment is " + numReg;
    }

}
