package com.tuandev.springboot.demojpa;

import com.tuandev.springboot.demojpa.dao.AppDAO;
import com.tuandev.springboot.demojpa.entity.Instructor;
import com.tuandev.springboot.demojpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemojpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemojpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			findInstructorDetail(appDAO);

		};
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
