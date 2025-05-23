package com.example.backend_kutuphane.entity;


import com.example.backend_kutuphane.entity.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private State states;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public State getStates() {
        return states;
    }
    public void setStates(State states) {
        this.states = states;
    }
    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

}