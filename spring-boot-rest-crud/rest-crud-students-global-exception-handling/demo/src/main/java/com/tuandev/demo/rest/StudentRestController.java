package com.tuandev.demo.rest;

import com.tuandev.demo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> st;

    /* @PostConstruct
    *  load st data ... only one
    * */
    @PostConstruct
    public void loadData(){
        st = new ArrayList<>();
        st.add(new Student("nguyen", "nguyen@gmail.com","hanoi"));
        st.add(new Student("an", "an@gmail.com","hanoi"));
        st.add(new Student("ha", "ha@gmail.com","hanoi"));
    }

    // define endpoint "/student" -return a list of student
    @GetMapping("/student")
    public List<Student> getStudent(){
      return st;
    }


    // define endpoint "/student/{studentId}" - return student at index
    // add request mapping to Spring REST Service
    // Bind path variable to method parameter using @PathVariable
    @GetMapping("/student/{studentId}")
    public  Student getStudent(@PathVariable int studentId) {

        // Exception
        // check the student again list size
        if(studentId>= st.size() || (studentId< 0) ){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return st.get(studentId);
    }


/* Exception Handle
* 1.Create a custom error response class
* 2.Create a custom exception class
* 3.Update REST service to throw exception if student not found
* 4.Add an exception handle method using @@ExceptionHandler
* */
/*

    //add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add another exception handler ... to catch any exception ( catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex){

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
*/
}

