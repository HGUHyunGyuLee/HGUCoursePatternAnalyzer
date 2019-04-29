package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {

	private String[] lines = { "1999-1, JC Nam, Java Programming", "1999-2, JC Nam, Programming Language Theory",
			"1999-1, JC Nam, Data Structures", "2001-1, JC Nam, Database Systems", "2018-1, SB Lim, Java Programming",
			"2018-2, SB Lim, Programming Language Theory", "2019-1, SB Lim, Data Structures",
			"2019-1, SB Lim, Algorithm Analysis", "2018-1, SJ Kim, Java Programming",
			"2018-2, SJ Kim, Programming Language Theory", "2019-1, SJ Kim, Logic Design",
			"2019-1, SJ Kim, Algorithm Analysis", };

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;

	/**
	 * This method runs our analysis logic to get the list of student and course
	 * names from lines.
	 * 
	 * @param args
	 */
	public void run(String[] args) {

		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
		students = new Student[numOfStudents];
		courses = new Course[numOfCourses];

		students = initiateStudentArrayFromLines(lines);

		System.out.println("Number of All Students: " + numOfStudents);

		for (Student student : students) {
			System.out.println(student.getName());
		}

		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for (Course course : courses) {
			System.out.println(course.getCourseName());
		}

	}

	/**
	 * This method returns a Student array to initiate the field, students, from
	 * lines.
	 * 
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {

		int count = 0; // operation 1
		// TODO: implement this method

		for (int i = 0; i < lines.length; i++) {

			if (!(studentExist(students, new Student(lines[i].trim().split(", ")[1])))) {
				students[count] = new Student(lines[i].trim().split(", ")[1]);
				if (count != numOfStudents - 1)
					count++;
			} else {

				continue;
			}
		}
		/*
		 * // operation 2 
		 * for(int i=0; i<lines.length;) { students[count] = new
		 * Student(lines[i].trim().split(", ")[1]);
		 * 
		 * if(count==numOfStudents-1)break;
		 * 
		 * else { if((studentExist(students,students[count]))) {
		 * for(;lines[i].trim().split(", ")[1].equals(students[count].getName()) && i <
		 * lines.length-1;i++); count++; } }
		 * 
		 * }
		 */
		return students;
	}

	/**
	 * This method check if there is the same name of the second argument in the
	 * array, students
	 * 
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {

		// TODO: implement this Method
		for (int i = 0; i < numOfStudents; i++) {
			if (students[i] != null && student.getName().equals(students[i].getName()))
				return true;
		}
		return false;
	}

	/**
	 * This method returns a Course array to initiate the field, courses, from
	 * lines.
	 * 
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		int count = 0;
		// TODO: implement this method

		for (int i = 0; i < lines.length; i++) {
			if (!(courseExist(courses, new Course(lines[i].trim().split(", ")[2])))) {
				courses[count] = new Course(lines[i].trim().split(", ")[2]);

				if (count != numOfCourses - 1)
					count++;
			} else {
				continue;
			}
		}

		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the
	 * array, courses.
	 * 
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		// TODO: implement this method

		for (int i = 0; i < numOfCourses; i++) {
			if (courses[i] != null && course.getCourseName().equals(courses[i].getCourseName()))
				return true;
		}

		return false;
	}

}
