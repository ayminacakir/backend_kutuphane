package com.example.backend_kutuphane.controllers;

import com.example.backend_kutuphane.dto.BooksDTO;
import com.example.backend_kutuphane.entities.Books;
import com.example.backend_kutuphane.entities.enums.States;
import com.example.backend_kutuphane.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }


    @GetMapping
    public ResponseEntity<List<BooksDTO>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }


    @GetMapping("/{id}")
    public ResponseEntity<BooksDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(booksService.getBookById(id));
    }


    @GetMapping("/status/{status}")
    public ResponseEntity<List<BooksDTO>> getBooksByStatus(@PathVariable States status) {
        return ResponseEntity.ok(booksService.getBooksByStatus(status));
    }


    @GetMapping("/author/{author}")
    public ResponseEntity<List<BooksDTO>> getBooksByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(booksService.getBooksByAuthor(author));
    }


    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Books book) {
        booksService.addBook(book);
        return ResponseEntity.ok("Kitap başarıyla eklendi!");
    }



    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Books updatedBook) {
        booksService.updateBook(id, updatedBook);
        return ResponseEntity.ok("Kitap başarıyla güncellendi!");
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        booksService.deleteBook(id);
        return ResponseEntity.ok("Kitap başarıyla silindi!");
    }
}
