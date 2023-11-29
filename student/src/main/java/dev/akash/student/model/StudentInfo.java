package dev.akash.student.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentInfo {
    

   
    private long id;
    private String firstName;
    private String lastName;
    private int grade;
    private char section;
    
}
