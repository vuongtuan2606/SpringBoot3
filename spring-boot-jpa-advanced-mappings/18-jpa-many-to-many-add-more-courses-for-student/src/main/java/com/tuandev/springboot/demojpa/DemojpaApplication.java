package com.tuandev.springboot.demojpa;

import com.tuandev.springboot.demojpa.dao.AppDAO;
import com.tuandev.springboot.demojpa.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemojpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			//createCourseAndStudents(appDAO);
			//findCourseAndStudents(appDAO);
			addMoreCoursesForStudent(appDAO);
		};
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("ruby");
		Course tempCourse2 = new Course("facebook");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: " + tempStudent);
		System.out.println("associated courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!");
	}


	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("tiktok");

		// create the students
		Student tempStudent1 = new Student("Tuan", "Vuong", "tuanvuong@gmail.com");
		Student tempStudent2 = new Student("nguyen", "ha", "nguyenha.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		appDAO.save(tempCourse);

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 12;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}
	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int theId = 11;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course
		System.out.println(tempCourse);

		// print the reviews
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("spring boot ");

		// add some reviews
		tempCourse.addReview(new Review("funny"));
		tempCourse.addReview(new Review("good"));


		// save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("Hai");

		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}
	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;

		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor =
				new Instructor("nguyen", "duy", "nguyenduy@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"nguyenduy@/youtobe",
						"game");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("java spring");
		Course tempCourse2 = new Course("php ");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructordetail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theID = 1;
		System.out.print("Finding instructorDetail id:" +theID);
		System.out.print("\n") ;
		InstructorDetail temp = appDAO.findInstructorDetaillById(theID);
		System.out.print("temp: " +temp) ;
		System.out.print("\n") ;
		System.out.print("the associated instructor only "+temp.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theID=1;

		System.out.print("Finding instructor id:" +theID);

		Instructor tempInstructor = appDAO.findInstructorById(theID);

		System.out.print("tempInstructor: "+tempInstructor);

		System.out.print("the associated instructorDetail only "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor =
				new Instructor("vuong", "tuan", "vuongtuan@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"vuongtuan@/youtobe",
						"code");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: this will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
