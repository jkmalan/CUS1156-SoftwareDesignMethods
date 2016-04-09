package com.jkmalan.Lab2.Part1;

import java.util.Scanner;

/**
 * This program tests the functionality of ClassRoster by building up a roster with student information
 * and then testing each of the public methods
 * @author Bonnie MacKellar
 *
 */
public class ClassRosterTester
{

    private static Scanner input;

    public static void main(String[] args)
    {
        input = new Scanner(System.in);
        ClassRoster roster = new ClassRoster();


        // input 3 students
        for (int i=0;i<3;i++)
        {
            StudentRecord student = inputStudent();
            roster.addStudent(student);
        }

        double classFinalAverage = roster.finalAverageForClass();
        System.out.println("The average semester grade for the entire class was " + classFinalAverage);

        if (roster.didStudentsImprove())
            System.out.println("The students improved their grades from the midterm to the final");
        else
            System.out.println("The students did worse on the final than the midterm");

        System.out.println("Who would you like to search for? Enter the SSN");
        String ssn =  input.next();
        StudentRecord foundStudent = roster.findStudentBySsn(ssn);
        if (foundStudent == null)
            System.out.println("The student was not found");
        else
            foundStudent.display();

        roster.display();
    }

    private static StudentRecord inputStudent()
    {
        StudentRecord student = new StudentRecord();
        System.out.println("Input first name");
        student.setFirstName(input.next());
        System.out.println("Input last name");
        student.setLastName(input.next());
        System.out.println("Input social security number");
        student.setSsn(input.next());
        System.out.println("Input year");
        student.setYear(input.next());
        System.out.println("Input midterm grade");
        student.setMidtermGrade(input.nextDouble());
        System.out.println("Input final grade");
        student.setFinalGrade(input.nextDouble());
        System.out.println("Input homework1 grade");
        student.setHomework1Grade(input.nextDouble());
        System.out.println("Input homework2 grade");
        student.setHomework2Grade(input.nextDouble());
        System.out.println("Input homework3 grade");
        student.setHomework3Grade(input.nextDouble());
        return student;
    }

}