package com.jkmalan.Lab2.Part2;


import java.util.ArrayList;

/**
 * This represents the information and grades for a single student
 *
 * @author jkmalan (aka John Malandrakis)
 */
public class StudentRecord {

    public static final double FINAL_WEIGHT = .25;
    public static final double MIDTERM_WEIGHT = .25;
    public static final double HMWK_AVERAGE_WEIGHT = .5;

    private String firstName;
    private String lastName;
    private String ssn;
    private String year;

    private ArrayList<GradeRecord> exams = new ArrayList<>();
    private ArrayList<GradeRecord> homeworks = new ArrayList<>();

    /**
     * Returns the student's first name
     *
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's first name
     *
     * @param firstName The first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the student's last name
     *
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the student's last name
     *
     * @param lastName The last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the student's social security number
     *
     * @return The ssn
     */
    public String getSsn() {
        return ssn;
    }

    /**
     * Sets the student's social security number
     *
     * @param ssn The ssn
     */
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    /**
     * Returns the student's current year
     *
     * @return The year
     */
    public String getYear() {
        return year;
    }

    /**
     * Sets the student's current year
     *
     * @param year The year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * Returns an exam grade using the exam name
     *
     * @param name The exam name
     * @return If found, returns the grade, else returns -1
     */
    public double getExamGrade(String name) {
        for (GradeRecord record : exams) {
            if (record.getName().equalsIgnoreCase(name)) {
                return record.getGrade();
            }
        }
        return -1;
    }

    /**
     * Adds an exam to the record
     *
     * @param name The exam name
     * @param grade The exam grade
     */
    public void addExam(String name, double grade) {
        exams.add(new GradeRecord(name, grade));
    }

    /**
     * Returns a homework grade using the assignment name
     *
     * @param name The assignment name
     * @return If found, returns the grade, else returns -1
     */
    public double getHomeworkGrade(String name) {
        for (GradeRecord record : homeworks) {
            if (record.getName().equalsIgnoreCase(name)) {
                return record.getGrade();
            }
        }
        return -1;
    }

    /**
     * Adds a homework assignment to the record
     *
     * @param name The assignment name
     * @param grade The assignment grade
     */
    public void addHomework(String name, double grade) {
        homeworks.add(new GradeRecord(name, grade));
    }

    /**
     * Sets the midterm grade
     * Legacy method
     *
     * @param grade The exam grade
     */
    public void setMidtermGrade(double grade) {
        addExam("midterm", grade);
    }

    /**
     * Sets the final grade
     * Legacy method
     *
     * @param grade The exam grade
     */
    public void setFinalGrade(double grade) {
        addExam("final", grade);
    }

    /**
     * Sets the homework1 grade
     * Legacy method
     *
     * @param grade The homework grade
     */
    public void setHomework1Grade(double grade) {
        addHomework("homework1", grade);
    }

    /**
     * Sets the homework2 grade
     * Legacy method
     *
     * @param grade The homework grade
     */
    public void setHomework2Grade(double grade) {
        addHomework("homework2", grade);
    }

    /**
     * Sets the homework3 grade
     * Legacy method
     *
     * @param grade The homework grade
     */
    public void setHomework3Grade(double grade) {
        addHomework("homework3", grade);
    }

    /**
     * Returns the midterm grade
     * Legacy method
     *
     * @return The exam grade
     */
    public double getMidtermGrade() {
        return getExamGrade("midterm");
    }

    /**
     * Returns the final grade
     * Legacy method
     *
     * @return The exam grade
     */
    public double getFinalGrade() {
        return getExamGrade("final");
    }

    /**
     * Returns the homework1 grade
     * Legacy method
     *
     * @return The homework grade
     */
    public double getHomework1Grade() {
        return getHomeworkGrade("homework1");
    }

    /**
     * Returns the homework2 grade
     * Legacy method
     *
     * @return The homework grade
     */
    public double getHomework2Grade() {
        return getHomeworkGrade("homework2");
    }

    /**
     * Returns the homework3 grade
     * Legacy method
     *
     * @return The homework grade
     */
    public double getHomework3Grade() {
        return getHomeworkGrade("homework3");
    }

    /**
     * Computes the weighted average for the student
     *
     * @return The weighted average
     */
    public double finalAverage() {
        double homeworkAverage = 0;
        for (GradeRecord record : homeworks) {
            homeworkAverage += record.getGrade();
        }
        homeworkAverage = homeworkAverage / homeworks.size();

        return (homeworkAverage * HMWK_AVERAGE_WEIGHT) + (getExamGrade("midterm") * MIDTERM_WEIGHT) + (getExamGrade("final") * FINAL_WEIGHT);
    }

    /**
     * Prints a student's information and grades
     */
    public void display() {
        System.out.println("Name : " + firstName + " " + lastName);
        System.out.println("Social Security Number " + ssn);
        System.out.println("Class : " + year);

        System.out.println("Midterm grade : " + getMidtermGrade());
        System.out.println("Final grade : " +  getFinalGrade());
        System.out.println("Homework1 grade : " + getHomework1Grade());
        System.out.println("Homework2 grade : " + getHomework2Grade());
        System.out.println("Homework3 grade : " + getHomework3Grade());
    }

}