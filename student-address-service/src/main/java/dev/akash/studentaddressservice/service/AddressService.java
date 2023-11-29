package dev.akash.studentaddressservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.akash.studentaddressservice.model.AddressInfo;
import dev.akash.studentaddressservice.repo.AddressRepo;

import java.util.List;
import java.util.Optional;



@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    
    public String enterStudentDetails(AddressInfo addressInfo){
        System.out.println(addressInfo.getId());
        System.out.println(addressInfo.getName());
        System.out.println(addressInfo);
        addressRepo.save(addressInfo);
        return "data entered";
    }

    public List<AddressInfo> getStudentDetails(){
        return addressRepo.findAll();
    }
    public Optional<AddressInfo> getStudentDetailsById(long id){
        return addressRepo.findById(id);
    }
}
