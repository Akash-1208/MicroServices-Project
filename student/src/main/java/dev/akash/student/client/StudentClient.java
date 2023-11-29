package dev.akash.student.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.akash.student.model.StudentInfo;


@FeignClient(name="STUDENT-SERVICE")
public interface StudentClient {
    
    @RequestMapping(method = RequestMethod.GET,value="/students/{id}")
    public StudentInfo getStudentDetails(@PathVariable long id);

    @GetMapping(value="/students")
    public List<StudentInfo> getStudents();

    
}
