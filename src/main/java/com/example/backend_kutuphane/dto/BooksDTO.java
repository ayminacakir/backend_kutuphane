package com.example.backend_kutuphane.dto;

import com.example.backend_kutuphane.entities.enums.States;

public class BooksDTO {

    private Long id;
    private String title;
    private String author;
    private String categoryName;
    private States states;

    // Parametreli constructor
    public BooksDTO(Long id, String title, String author, String categoryName, States states) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.categoryName = categoryName;
        this.states = states;
    }

    // Getter ve Setter metodları
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public States getStates() {
        return states;
    }

    public void setStates(States states) {
        this.states = states;
    }
}
