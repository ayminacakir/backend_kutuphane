package com.example.backend_kutuphane.entities;

import jakarta.persistence.*;

@Entity
public class Fines {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Borrows borrow;

    private double amount;
    private boolean paid;
}