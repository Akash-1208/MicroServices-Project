package dev.akash.studentaddressservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import dev.akash.studentaddressservice.model.AddressInfo;
import dev.akash.studentaddressservice.repo.AddressRepo;
import dev.akash.studentaddressservice.service.AddressService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AddressController {
    
    @Autowired
    AddressRepo addressRepo; 

    @Autowired
    AddressService addressService;

    @PostMapping(value="/address")
    public String enterStudentDetails(@RequestBody AddressInfo addressInfo) {

        String s=addressService.enterStudentDetails(addressInfo);
        if(s.equals("data entered")){
            return "Student Data has been Entered Successfully";
        }
        return "data not entered";
    }

    @GetMapping(value="/address")
    public List<AddressInfo> getStudentDetails(){
        return addressService.getStudentDetails();
    }
    @GetMapping(value="/address/{id}")
    public Optional<AddressInfo>  getStudentDetailsById(@PathVariable long id){
        return addressService.getStudentDetailsById(id);
    }
  

}
