package com.example.backend_kutuphane.dto;

import com.example.backend_kutuphane.entities.enums.States;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BooksDTO {
    private Long id;
    private String title;
    private String author;
    private String categoryName;
    private States state;

    public BooksDTO(Long id, String title, String author, String categoryName,States state) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.categoryName = categoryName;
        this.state = state;
    }
}

