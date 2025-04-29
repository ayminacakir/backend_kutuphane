package com.example.backend_kutuphane.repositories;

import com.example.backend_kutuphane.entity.Fines;
import com.example.backend_kutuphane.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface FinesRepository extends JpaRepository<Fines, Long> {
    Optional<Fines> findByUserAndPaidFalse(Users user);
}
