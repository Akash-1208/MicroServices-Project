package dev.akash.studentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.akash.studentservice.model.StudentInfo;

public interface StudentRepo extends JpaRepository<StudentInfo,Long>{
    
}
