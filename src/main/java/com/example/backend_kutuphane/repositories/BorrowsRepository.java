package com.example.backend_kutuphane.repositories;

import com.example.backend_kutuphane.entity.Books;
import com.example.backend_kutuphane.entity.Borrows;
import com.example.backend_kutuphane.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BorrowsRepository extends JpaRepository<Borrows,Long> {
    List<Borrows> findByUserId(Long userId);
    List<Borrows> findByBookId(Long bookId);
    Optional<Borrows> findByBookIdAndReturnDateIsNull(Long bookId);

    List<Borrows> findByUser(Users user);

    List<Borrows> findByBook(Books book);

    List<Borrows> findByReturnDateIsNull();
}

