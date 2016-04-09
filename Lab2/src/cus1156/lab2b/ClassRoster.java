package cus1156.lab2b;

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
	* @return the average of the students weighted grades.
	*/
	public double finalAverageForClass()
	{
		double sum = 0;
		for (StudentRecord rec : students)
		{
			sum += rec.finalAverage();
		}
	return sum / students.size();

	}

	/**
	 * given a student's ssn, return the entire student record
	 *
	 * @param ssn - the student's social security number
	 * @return - the StudentRecord or null if not found
	 */
	public StudentRecord findStudentBySsn(String ssn)
	{
		for (StudentRecord record : students)
		{
			if (record.getSsn().equalsIgnoreCase(ssn))
			{
				return record;
			}
		}
		return null;
	}

	/**
	 * return true if the class did better on average on the final exam than on the midterm
	 *
	 * @return true if the class did better on the final, false if they did better on the midterm
	 */
	public boolean didStudentsImprove()
	{

		double sumFinal = 0;
		double sumMid = 0;
		for (StudentRecord record : students)
		{
			sumFinal += record.getFinalGrade();
			sumMid += record.getMidtermGrade();
		}

		double avgFinal = sumFinal / students.size();
		double avgMid = sumMid / students.size();
		if (avgFinal > avgMid)
			return true;
		else
			return false;
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
		double finalExamGradeTotal = 0.0;
		for (StudentRecord student : students)
			finalExamGradeTotal = student.getFinalGrade() + finalExamGradeTotal;

		double average = finalExamGradeTotal / students.size();
		return average;
	}

	private double calcMidtermAverageForAllClass()
	{
		double midtermGradeTotal = 0.0;
		for (StudentRecord student : students)
			midtermGradeTotal = student.getMidtermGrade() + midtermGradeTotal;

		double average = midtermGradeTotal / students.size();
		return average;
	}

}

          