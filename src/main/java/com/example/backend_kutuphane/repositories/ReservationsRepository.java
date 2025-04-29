package com.example.backend_kutuphane.repositories;

import com.example.backend_kutuphane.entity.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
    List<Reservations> findByUserId(Long userId);
    List<Reservations> findByBookId(Long bookId);
    boolean existsByBookIdAndUserId(Long bookId, Long userId);

}
