package dev.akash.studentaddressservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.akash.studentaddressservice.model.AddressInfo;

public interface AddressRepo extends JpaRepository<AddressInfo,Long>{
    
}
