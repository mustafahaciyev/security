package com.example.security.repo;

import com.example.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users,Long> {

    Optional<Users> findByName(String name);

}
