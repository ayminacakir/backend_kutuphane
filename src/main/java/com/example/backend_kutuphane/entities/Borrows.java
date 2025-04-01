package com.example.backend_kutuphane.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Borrows {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Books book;

    private LocalDate borrowDate;
    private LocalDate returnDate;
}