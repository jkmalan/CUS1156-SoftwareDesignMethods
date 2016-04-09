package com.jkmalan.Lab4;

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
        	  double totalAverages=0.0;
    		  for (StudentRecord  student : students) 
    					  totalAverages = student.finalAverage() + totalAverages;
    				 
    			double average = totalAverages/students.size();
				return average;
        		 
				}
        	
          /**
           * given a student's ssn, return the entire student record
           * @param ssn - the student's social security number
           * @return - the StudentRecord or null if not found
           */
          public StudentRecord findStudentBySSN(String ssn)
        	  {
        	  int ctr = 0;
    		  while (ctr <students.size())
    		  {
    			  StudentRecord theStudent = students.get(ctr);
    			  if (theStudent.getSsn().equals(ssn))  // record was found
    			     return theStudent;
    			   ctr++;
    		  }
    		  return null;  // not found
        	  }
          
          /**
           * return true if the class did better on average on the final exam than on the midterm
           * @return true if the class did better on the final, false if they did better on the midterm
           */
          public boolean didStudentsImprove()
        	  {
        	  double classMidtermAverage = findClassMidtermAverage();
      		  double classFinalExamAverage = findFinalExamAverage();
      	   
      		  System.out.println("midterm av is " + classMidtermAverage);
      		  System.out.println("final av is " + classFinalExamAverage);
      		  
      		  if (classFinalExamAverage > classMidtermAverage)
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
          
		private double findFinalExamAverage()
			{
				  double finalExamGradeTotal=0.0;
        		  for (StudentRecord  student : students) 
        					  finalExamGradeTotal = student.getFinalGrade() + finalExamGradeTotal;
        				 
        			double average = finalExamGradeTotal/students.size();
					return average;
			}

		private double findClassMidtermAverage()
			{
				  double midtermGradeTotal=0.0;
        		  for (StudentRecord  student : students) 
        					  midtermGradeTotal = student.getMidtermGrade() + midtermGradeTotal;
        				 
        			double average = midtermGradeTotal/students.size();
					return average;
			}
		
		 /**
         * This produces a formatted string containing the information for each student,
         * suitable for output to standard out or a file.
         * @return a formatted string
         */
        public String toString()
        {
      	  String output = "The students in the class : \n";
      	  for (StudentRecord student : students)
					output = output + student.toString();
      	  
      	  return output;
        }
	}
