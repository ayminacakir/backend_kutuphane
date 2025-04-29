package com.example.backend_kutuphane.repositories.user;

import com.example.backend_kutuphane.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);
    boolean existsByEmail(String email);


    Optional<Users> findByUsernameEquals(String username);
}
