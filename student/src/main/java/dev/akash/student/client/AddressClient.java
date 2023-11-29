package dev.akash.student.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.akash.student.model.AddressInfo;



@FeignClient(name="ADDRESS")
public interface AddressClient {

    @RequestMapping(method = RequestMethod.GET,value="/address/{id}")
    public AddressInfo getAddressDetails(@PathVariable long id);

    @GetMapping(value="/address")
    public List<AddressInfo> getStudentAddress();


    
}
