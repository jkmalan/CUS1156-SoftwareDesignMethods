package com.jkmalan.Lab2.Part1;

/**
 * This represents the information and grades for a single student
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class StudentRecord
{
    public static final double FINAL_WEIGHT=.25;
    public static final double  MIDTERM_WEIGHT= .25;
    public static final double HMWK_AVERAGE_WEIGHT = .5;

    private String firstName;
    private String lastName;
    private String ssn;
    private String year;

    private double finalGrade;
    private double midtermGrade;
    private double homework1Grade;
    private double homework2Grade;
    private double homework3Grade;


    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void setSsn(String ssn)
    {
        this.ssn = ssn;
    }

    public double getHomework2Grade()
    {
        return homework2Grade;
    }


    public void setFirstName(String name)
    {
        firstName = name;
    }

    public void setLastName(String name)
    {
        lastName = name;

    }

    public void setMidtermGrade(double mid)
    {
        midtermGrade = mid;
    }

    public void setFinalGrade(double fin)
    {
        finalGrade = fin;

    }

    public void setHomework1Grade(double hmwk1)
    {
        homework1Grade = hmwk1;

    }

    public void setHomework2Grade(double hmwk)
    {
        homework2Grade = hmwk;

    }



    public void setHomework3Grade(double hmwk)
    {
        homework3Grade = hmwk;

    }


    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public double getMidtermGrade()
    {
        return midtermGrade;
    }



    public double getFinalGrade()
    {
        return finalGrade;
    }



    public double getHomework1Grade()
    {
        return homework1Grade;
    }



    public double getHomework3Grade()
    {
        return homework3Grade;
    }

    /**
     * Computes the weighted average for the student
     *
     * @return The weighted average
     */
    public double finalAverage()
    {
        double homeworkAverage = (homework1Grade + homework2Grade + homework3Grade )/3.0;
        return (homeworkAverage *  HMWK_AVERAGE_WEIGHT) + (midtermGrade * MIDTERM_WEIGHT)+ (finalGrade * FINAL_WEIGHT);
    }

    /**
     * Prints a student's information and grades
     */
    public void display()
    {
        System.out.println("Name : " + firstName + " " + lastName);
        System.out.println("Social Security Number " + ssn);
        System.out.println("Class : " + year);

        System.out.println("Midterm grade : " + midtermGrade);

        System.out.println("Final grade : " +  finalGrade);

        System.out.println("Homework1 grade : " + homework1Grade);

        System.out.println("Homework2 grade : " + homework2Grade);

        System.out.println("Homework3 grade : " + homework3Grade);


    }

}