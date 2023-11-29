package dev.akash.studentservice.controller;

import org.springframework.web.bind.annotation.RestController;

import dev.akash.studentservice.model.StudentInfo;
// import dev.akash.studentservice.repo.StudentRepo;
import dev.akash.studentservice.service.StudentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

    

    @Autowired
    private StudentService studentService;

    @PostMapping(value="/students")
    @CircuitBreaker(name="student_breaker",fallbackMethod = "errorPageMethod")
    public String enterStudentDetails(@RequestBody StudentInfo studentInfo) {

        String s=studentService.enterStudentDetails(studentInfo);
        if(s.equals("data entered")){
            return "Student Data has been Entered Successfully";
        }
        return "data not entered";
    }

    public static ResponseEntity<?> errorPageMethod(Exception ex){
        new StudentInfo();
        StudentInfo studentInfo= StudentInfo.builder().id(0).firstName("dummy").build();
        return ResponseEntity.ok(studentInfo);
    }

    @GetMapping(value="/students")
    public List<StudentInfo> getStudentDetails(){
        return studentService.getStudentDetails();
    }
    @GetMapping(value="/students/{id}")
    public Optional<StudentInfo>  getStudentDetailsById(@PathVariable long id){
        return studentService.getStudentDetailsById(id);
    }
    
    
}
