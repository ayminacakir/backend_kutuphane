package com.example.backend_kutuphane.entities;

import jakarta.persistence.*;

import javax.management.relation.Role;
import java.util.List;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String email;
    private String password;



    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Borrows> borrows;

}