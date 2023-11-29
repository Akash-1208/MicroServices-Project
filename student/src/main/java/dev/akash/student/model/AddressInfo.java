package dev.akash.student.model;





import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class AddressInfo {
    


    private long id;
    private String name;
    private String address;
    private String district;
    private String state; 
    
}
