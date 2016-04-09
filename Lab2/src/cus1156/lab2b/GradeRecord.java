package cus1156.lab2b;

public class GradeRecord
{

	private double Grade;
	private String Assignment;

	public GradeRecord(String name, double Grade)
	{
		this.Grade = Grade;
		this.Assignment = name;
	}

	public String getAssignment()
	{
		return Assignment;
	}

	public double getGrade()
	{
		return Grade;
	}

	public void setAssignment(String name)
	{
		this.Assignment = name;
	}

	public void setGrade(double grade)
	{
		this.Grade = grade;
	}

}


	
