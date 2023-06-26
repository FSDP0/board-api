package com.boardapp.boardapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boardapp.boardapi.user.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}
