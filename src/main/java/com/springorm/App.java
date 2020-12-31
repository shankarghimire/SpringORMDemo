package com.springorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springorm.dao.StudentDao;
import com.springorm.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args)  {
		// System.out.println( "Hello World!" );

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);

		Student student = new Student();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean repeat = true;
		while (repeat) {

			System.out.println("********Welcome to Spring ORM Project*******************");
			System.out.println("1. Add New Student");
			System.out.println("2. Display All Students");
			System.out.println("3. Get Details of a Signle Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Upate Student");
			System.out.println("6. Quit");
			System.out.println();
			
			try {
				System.out.println("Please, Enter your Choice : ");

				int choice = Integer.parseInt(br.readLine());
				switch(choice) {
				case 1:
					System.out.println("Please, Enter the student details : ");
					System.out.println("Enter the Student Name : ");
					String studentName = br.readLine();
					System.out.println("Enter the Student City : ");
					String studentCity = br.readLine();
					student.setName(studentName);
					student.setStudentCity(studentCity);
					studentDao.insert(student);
					
					break;
				case 2:
					System.out.println("Display All Students : ");
					List<Student> allStudents = studentDao.getAllStudents();
					for(Student std : allStudents) {
						System.out.println(std.toString());
					}
					break;
				case 3:
					System.out.println("Single Student Details : ");
					System.out.println("Please, enter the student Id: ");
					int studentId = Integer.parseInt(br.readLine());
					Student student2 = studentDao.getStudent(studentId);
					System.out.println(student2);
					break;
				case 4:
					System.out.println("Delete Student  : ");
					System.out.println("Please, enter the student Id: ");
					studentId = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(studentId);
					break;
				case 5:
					System.out.println("Update Student  : ");
					System.out.println("Please, enter the student Id: ");
					studentId = Integer.parseInt(br.readLine());
					System.out.println("Enter the Student Name : ");
					studentName = br.readLine();
					System.out.println("Enter the Student City : ");
					studentCity = br.readLine();
					student.setName(studentName);
					student.setStudentId(studentId);
					student.setName(studentName);
					student.setStudentCity(studentCity);
					studentDao.updateStudent(student);
					break;
				case 6:
					System.out.println("Thanks for Using the Program!!! ");
					repeat = false;
					break;
				default:
					System.out.println("Invalid choice!!! Please, enter your choice between 1 to 6  :");
					br.readLine();
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				//applicationContext.close();
			}
		}

	}
}
