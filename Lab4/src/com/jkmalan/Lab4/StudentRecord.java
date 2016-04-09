package com.jkmalan.Lab4;

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
	 * compute the weighted score for the student, based on all of the assignments
	 * @return the weighted score
	 */
	public double finalAverage()
		{
			double homeworkAverage = (homework1Grade + homework2Grade + homework3Grade )/3.0;
			return (homeworkAverage *  HMWK_AVERAGE_WEIGHT) + (midtermGrade * MIDTERM_WEIGHT)+ (finalGrade * FINAL_WEIGHT);
		}

	/**
	 * print the information for the student
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

	/**
	 * produces a formatted String containing the information for one student
	 * The string is suitable for output to a file or the console
	 * @return a formatted string with information for the Student
	 */
	  public String toString()
	  {
		  String output;
		  output = "Name : " + firstName + " " + lastName + "\n";
		  output = output + "Social Security Number " + ssn + "\n";
		  output = output + "Class : " + year +"\n";
		  output = output + "Midterm grade : " + midtermGrade + "\n";
		  output = output + "Final grade : " +  finalGrade + "\n";
		  output = output + "Homework1 grade : " + homework1Grade + "\n";
		  output = output + "Homework2 grade : " + homework2Grade + "\n";
		  output = output + "Homework3 grade : " + homework3Grade + "\n";
			
		  return output;
	  }

	}
