package cus1156.lab2b;

import java.util.ArrayList;

/**
 * This represents a grade record for one student
 * @author Bonnie MacKellar
 *
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

        ArrayList<GradeRecord> Exams = new ArrayList<GradeRecord>();
        ArrayList<GradeRecord> Homeworks = new ArrayList<GradeRecord>();

	public String getSsn()
	{
		return ssn;
	}


	public String getYear()
	{
		return year;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public void setFirstName(String name)
	{
		firstName = name;
	}

	public void setLastName(String name)
	{
		lastName = name;
	}

	public void addHomework(String name, double grade)
	{
		GradeRecord rec = new GradeRecord(name, grade);
		Homeworks.add(rec);
	}

	public void addExam(String name, double grade)
	{
		GradeRecord rec = new GradeRecord(name, grade);
		Exams.add(rec);
	}

	public double getGradeExam(String name)
	{
		for (GradeRecord rec : Exams)
		{
			if (rec.getAssignment().equalsIgnoreCase(name))
				return rec.getGrade();
		}
		return -1;
	}

	public double getGradeHomework(String name)
	{
		for (GradeRecord rec : Homeworks)
		{
			if (rec.getAssignment().equalsIgnoreCase(name))
				return rec.getGrade();
		}
		return -1;
	}

	public void setMidtermGrade(double grade)
	{
		addExam("midterm", grade);
	}

	public void setFinalGrade(double grade)
	{
		addExam("final", grade);
	}

	public void setHomework1Grade(double grade)
	{
		addHomework("homework1", grade);
	}

	public void setHomework2Grade(double grade)
	{
		addHomework("homework2", grade);
	}

	public void setHomework3Grade(double grade)
	{
		addHomework("homework3", grade);
	}

	public double getMidtermGrade()
	{
		return getGradeExam("midterm");
	}

	public double getFinalGrade()
	{
		return getGradeExam("final");
	}

	public double getHomework1Grade()
	{
		return getGradeHomework("homework1");
	}

	public double getHomework2Grade()
	{
		return getGradeHomework("homework2");
	}

	public double getHomework3Grade()
	{
		return getGradeHomework("homework3");
	}

	/**
	 * compute the weighted score for the student, based on all of the assignments
	 * @return the weighted score
	 */
	public double finalAverage()
	{
		double homeworkAverage = 0;
		for (GradeRecord rec : Homeworks)
		{

		}
		return (homeworkAverage *  HMWK_AVERAGE_WEIGHT) + (getGradeExam("midterm") * MIDTERM_WEIGHT)+ (getGradeExam("final") * FINAL_WEIGHT);
	}

	/**
	 * print the information for the student
	 */
	public void display()
	{
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
