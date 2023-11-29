package dev.akash.student.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import dev.akash.student.client.AddressClient;
import dev.akash.student.client.StudentClient;
import dev.akash.student.model.AddressInfo;
import dev.akash.student.model.Student;
import dev.akash.student.model.StudentInfo;

@RestController
public class StudentController {
    

    // @Autowired
    // private AddressInfo addressInfo;
    // @Autowired
    // private StudentInfo studentInfo;
    @Autowired
    private StudentClient studentClient;
    @Autowired
    private AddressClient addressClient;

    @GetMapping(path="/school/{id}")
    public Student getAllDetails(@PathVariable long id){
       StudentInfo studentInfo= studentClient.getStudentDetails(id);
       System.out.println(studentInfo);
       System.out.println("here i am ");
       AddressInfo addressInfo= addressClient.getAddressDetails( id);
       System.out.println("here u are  ");
       Student s= new Student(studentInfo,addressInfo);
       return s;
    }

    @GetMapping(path="/schools")
    public List<Student> getAllStudentDetails(){
        List<AddressInfo> addressInfos=addressClient.getStudentAddress();
        System.out.println("here i am ");
        List<StudentInfo> studentInfos= studentClient.getStudents();
         System.out.println("here u are  ");
        
        List<Student> arr= new ArrayList<>();
        for(int i=0;i<studentInfos.size();i++){
            if(studentInfos.get(i).getId()==addressInfos.get(i).getId()){
                Student s= new Student(studentInfos.get(i),addressInfos.get(i));
                arr.add(s);
            }
        }
    return arr;
    }
}
