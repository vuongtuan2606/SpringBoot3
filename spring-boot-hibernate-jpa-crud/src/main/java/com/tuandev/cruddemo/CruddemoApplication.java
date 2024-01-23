package com.tuandev.cruddemo;

import com.tuandev.cruddemo.dao.StudentDAO;
import com.tuandev.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.text.html.HTML;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//update(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByName(studentDAO);
			//delete(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count"+numRowsDeleted);
	}

	private void delete(StudentDAO studentDAO) {
		int theId = 2;
		System.out.println("delete sv by id = 2");
		studentDAO.delete(theId);
	}

	private void update(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int theId = 1;
		System.out.println("Getting student with id : "+ theId);
		Student myStudent = studentDAO.FindByID(theId);

		// change name to "tuan"
		System.out.println("updating student");
		myStudent.setName("tuan");

		//update the student
		studentDAO.update(myStudent);

		//display the update student
		System.out.println("updated student"+myStudent);
	}

	private void queryForStudentByName(StudentDAO studentDAO) {
		List<Student> theStudent = studentDAO.FindByName("nguyen");

		for(Student items : theStudent){
			System.out.println(items);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		// get list sv of class student
		List<Student> ListSV = studentDAO.findAll();

		// display list sv
		for (Student items :ListSV){
			System.out.println(items);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Tạo mới sv");
		Student sv1 = new Student("an","hanoi","an@gmail.com");

		studentDAO.save(sv1);

		// hiển thị id của sv vừa lưu
		int theId = sv1.getId();
		System.out.println("lưu sinh viên: id="+theId);

		// lấy id sv vừa lưu
		Student mystudent = studentDAO.FindByID(theId);
		System.out.println("hiển thị sinh viên: id:" +mystudent);

	}

	private void createStudent(StudentDAO studentDAO){

		// tạo sv mới
		System.out.println("Tạo mới sv");
		Student sv = new Student("dai","hanoi","dai@gmail.com");

		// lưu sv
		studentDAO.save(sv);

		// hiển thị sv đã lưu
		System.out.println("lưu sinh viên có tên = "+sv.getName());
	}

}







