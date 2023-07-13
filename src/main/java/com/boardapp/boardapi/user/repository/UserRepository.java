package com.boardapp.boardapi.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boardapp.boardapi.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
