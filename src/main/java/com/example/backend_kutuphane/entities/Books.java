package com.example.backend_kutuphane.entities;


import com.example.backend_kutuphane.entities.enums.States;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.plaf.nimbus.State;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int publicationYear;

    @Enumerated(EnumType.STRING)
    private States state;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;
}