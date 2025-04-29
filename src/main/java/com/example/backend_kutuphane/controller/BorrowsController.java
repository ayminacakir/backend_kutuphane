package com.example.backend_kutuphane.controller;

import com.example.backend_kutuphane.dto.BorrowsDTO;
import com.example.backend_kutuphane.entity.Borrows;
import com.example.backend_kutuphane.entity.Users;
import com.example.backend_kutuphane.entity.Books;
import com.example.backend_kutuphane.services.BorrowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowsController {

    private final BorrowsService borrowsService;

    @Autowired
    public BorrowsController(BorrowsService borrowsService) {
        this.borrowsService = borrowsService;
    }

    // Kullanıcıya göre ödünç verilen kitapları listele
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowsDTO>> getBorrowsByUser(@PathVariable Long userId) {
        Users user = new Users();
        user.setId(userId);
        List<BorrowsDTO> borrows = borrowsService.getBorrowsByUser(user);
        return ResponseEntity.ok(borrows);
    }

    // Kitaba göre ödünç verilen kitapları listele
    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BorrowsDTO>> getBorrowsByBook(@PathVariable Long bookId) {
        Books book = new Books();
        book.setId(bookId);  // Kitabı ID'ye göre bulma
        List<BorrowsDTO> borrows = borrowsService.getBorrowsByBook(book);
        return ResponseEntity.ok(borrows);
    }

    // Ödünç verilmemiş kitapları listele (geri getirilmemiş)
    @GetMapping("/unreturned")
    public ResponseEntity<List<BorrowsDTO>> getUnreturnedBorrows() {
        List<BorrowsDTO> borrows = borrowsService.getUnreturnedBorrows();
        return ResponseEntity.ok(borrows);
    }

    // Ödünç kaydını ekle
    @PostMapping
    public ResponseEntity<String> addBorrow(@RequestBody Borrows borrow) {
        borrowsService.addBorrow(borrow);
        return ResponseEntity.ok("Ödünç kaydı başarıyla eklendi.");
    }

    // Ödünç kaydını güncelle
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBorrow(@PathVariable Long id, @RequestBody Borrows updatedBorrow) {
        borrowsService.updateBorrow(id, updatedBorrow);
        return ResponseEntity.ok("Ödünç kaydı başarıyla güncellendi.");
    }

    // Ödünç kaydını sil
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBorrow(@PathVariable Long id) {
        borrowsService.deleteBorrow(id);
        return ResponseEntity.ok("Ödünç kaydı başarıyla silindi.");
    }
}
