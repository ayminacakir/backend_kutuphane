package com.example.backend_kutuphane.repositories;

import com.example.backend_kutuphane.entity.Books;
import com.example.backend_kutuphane.entity.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books,Long> {
    List<Books>findByStates(State states);
    List<Books> findByAuthorContainingIgnoreCase(String author);
}
