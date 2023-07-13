package com.boardapp.boardapi.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boardapp.boardapi.address.entity.Address;


public interface AddressRepository extends JpaRepository<Address, String>{
    Address findByAddressZipcode(String addressZipcode);
}
