package com.example.backend_kutuphane.repositories;

import com.example.backend_kutuphane.entities.Fines;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FinesRepository extends JpaRepository<Fines, Long> {
    List<Fines> findByUserId(Long userId);
    Optional<Fines> findByUserIdAndPaidFalse(Long userId);
}
