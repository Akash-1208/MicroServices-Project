package dev.akash.studentservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import dev.akash.studentservice.model.StudentInfo;
import dev.akash.studentservice.repo.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    
    public String enterStudentDetails(StudentInfo studentInfo){
        System.out.println(studentInfo.getId());
        System.out.println(studentInfo.getFirstName());
        System.out.println(studentInfo);
        studentRepo.save(studentInfo);
        return "data entered";
    }

    public List<StudentInfo> getStudentDetails(){
        return studentRepo.findAll();
    }
    public Optional<StudentInfo> getStudentDetailsById(long id){
        return studentRepo.findById(id);
    }
}
