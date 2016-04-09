package com.jkmalan.Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



/**
 * This program tests the functionality of ClassRoster by building up a roster with student information
 * and then testing each of the public methods
 * @author Bonnie MacKellar
 * @author jkmalan (aka John Malandrakis)
 *
 */
public class ClassRosterTester
	{

		public static void main(String[] args)
			{

				ClassRoster roster = null;

				try {
					roster = inputStudentsFromFile();

					double classFinalAverage = roster.finalAverageForClass();
					System.out.println("The average semester grade for the entire class was " + classFinalAverage);

					if (roster.didStudentsImprove())
						System.out.println("The students improved their grades from the midterm to the final");
					else
						System.out.println("The students did worse on the final than the midterm");

					Scanner input = new Scanner(System.in);

					System.out.println("Would you like to view roster on screen or in file? (monitor/file)?");
					String option = input.nextLine();
					if (option.equalsIgnoreCase("monitor") || option.equalsIgnoreCase("m")) {
						System.out.println(roster.toString());
					} else if (option.equalsIgnoreCase("file") || option.equalsIgnoreCase("f")) {
						FileWriter writer = new FileWriter(new File("Lab4/report.txt"));
						writer.write(roster.toString());
						writer.close();
					} else {
						System.out.println("Bad input, skipping roster display.");
					}

				} catch (FileNotFoundException e) {
					System.out.println("Error: The file could not be found!");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error: Unable to write to the log file!");
					e.printStackTrace();
				}

				System.out.println("Done!");
			}

		private static StudentRecord inputStudentFromConsole()
			{
			   Scanner input = new Scanner(System.in);
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
				 input.close();
				return student;
			}

		// this is the new method for lab4
		private static ClassRoster inputStudentsFromFile() throws FileNotFoundException {

			ClassRoster roster = new ClassRoster();

			File file = new File("Lab4/students.txt");
			System.out.println(file.getAbsolutePath());

			Scanner input = new Scanner(file);

			while (input.hasNextLine()) {
				String line = input.nextLine();

				StudentRecord student = getStudentFromLine(line);
				roster.addStudent(student);
			}

			input.close();

			return roster;

		}

		public static StudentRecord getStudentFromLine(String line) {
			StudentRecord student = new StudentRecord();

			Scanner input = new Scanner(line);
			input.useDelimiter(",");

			student.setFirstName(input.next());
			student.setLastName(input.next());
			student.setSsn(input.next());
			student.setYear(input.next());

			student.setMidtermGrade(input.nextDouble());
			student.setFinalGrade(input.nextDouble());
			student.setHomework1Grade(input.nextDouble());
			student.setHomework2Grade(input.nextDouble());
			student.setHomework3Grade(input.nextDouble());

			input.close();

			return student;
		}
	}
