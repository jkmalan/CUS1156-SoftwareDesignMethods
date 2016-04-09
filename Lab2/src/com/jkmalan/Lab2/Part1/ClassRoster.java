package com.jkmalan.Lab2.Part1;

import java.util.ArrayList;

/**
 * This represents the students taking a class
 * @author Bonnie MacKellar
 *
 */
public class ClassRoster
{
    private ArrayList<StudentRecord> students = new ArrayList<StudentRecord>();

    /**
     * Add a student to the roster
     * @param student
     */
    public void addStudent(StudentRecord student)
    {
        students.add(student);
    }

    /**
     * compute the average of all of the final weighted grades (taking into
     * account all homeworks and exams) across the entire class
     *
     * @return the average of the students weighted grades.
     */
    public double finalAverageForClass() {
        double sum = 0;
        for (StudentRecord record : students) {
            sum += record.finalAverage();
        }
        return sum / students.size();
    }

    /**
     * Returns a student record by social security number
     *
     * @param ssn The student's ssn
     * @return The student record
     */
    public StudentRecord findStudentBySsn(String ssn) {
        for (StudentRecord record : students) {
            if (record.getSsn().equalsIgnoreCase(ssn)) {
                return record;
            }
        }

        return null;
    }

    /**
     * Compares the class average of the final to the class average of the midterm
     *
     * @return If students improved, return true, else return false
     */
    public boolean didStudentsImprove() {
        double sumFinal = 0;
        double sumMid = 0;
        for (StudentRecord record : students) {
            sumFinal += record.getFinalGrade();
            sumMid += record.getMidtermGrade();
        }

        double avgFinal = sumFinal / students.size();
        double avgMid = sumMid / students.size();
        if (avgFinal > avgMid) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * print out the students in the class
     */
    public void display()
    {
        System.out.println("The students in the class : ");
        for (StudentRecord student : students)
            student.display();

    }

    private double calcFinalExamAverageForAllClass()
    {
        double finalExamGradeTotal=0.0;
        for (StudentRecord  student : students)
            finalExamGradeTotal = student.getFinalGrade() + finalExamGradeTotal;

        double average = finalExamGradeTotal/students.size();
        return average;
    }

    private double calcMidtermAverageForAllClass()
    {
        double midtermGradeTotal=0.0;
        for (StudentRecord  student : students)
            midtermGradeTotal = student.getMidtermGrade() + midtermGradeTotal;

        double average = midtermGradeTotal/students.size();
        return average;
    }

}
