package com.example.backend_kutuphane.services;

import com.example.backend_kutuphane.dto.BorrowsDTO;
import com.example.backend_kutuphane.entities.Borrows;
import com.example.backend_kutuphane.entities.Users;
import com.example.backend_kutuphane.entities.Books;
import com.example.backend_kutuphane.repositories.BorrowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowsService {

    private final BorrowsRepository borrowsRepository;

    @Autowired
    public BorrowsService(BorrowsRepository borrowsRepository) {
        this.borrowsRepository = borrowsRepository;
    }


    public List<BorrowsDTO> getBorrowsByUser(Users user) {
        List<Borrows> borrows = borrowsRepository.findByUser(user);
        return borrows.stream()
                .map(borrow -> new BorrowsDTO(
                        borrow.getId(),
                        borrow.getBook().getId(),
                        borrow.getUser().getId(),
                        borrow.getBook().getTitle(),
                        borrow.getBorrowDate(),
                        borrow.getReturnDate()))
                .collect(Collectors.toList());
    }


    public List<BorrowsDTO> getBorrowsByBook(Books book) {
        List<Borrows> borrows = borrowsRepository.findByBook(book);
        return borrows.stream()
                .map(borrow -> new BorrowsDTO(
                        borrow.getId(),
                        borrow.getBook().getId(),
                        borrow.getUser().getId(),
                        borrow.getBook().getTitle(),
                        borrow.getBorrowDate(),
                        borrow.getReturnDate()))
                .collect(Collectors.toList());
    }

    public List<BorrowsDTO> getUnreturnedBorrows() {
        List<Borrows> borrows = borrowsRepository.findByReturnDateIsNull();
        return borrows.stream()
                .map(borrow -> new BorrowsDTO(
                        borrow.getId(),
                        borrow.getBook().getId(),
                        borrow.getUser().getId(),
                        borrow.getBook().getTitle(),
                        borrow.getBorrowDate(),
                        borrow.getReturnDate()))
                .collect(Collectors.toList());
    }


    public void addBorrow(Borrows borrow) {
        borrowsRepository.save(borrow);
    }


    public void updateBorrow(Long id, Borrows updatedBorrow) {
        Borrows borrow = borrowsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("\n" +
                        "Ödünç alma kaydı bulunamadı"));
        borrow.setBook(updatedBorrow.getBook());
        borrow.setUser(updatedBorrow.getUser());
        borrow.setBorrowDate(updatedBorrow.getBorrowDate());
        borrow.setReturnDate(updatedBorrow.getReturnDate());
        borrowsRepository.save(borrow);
    }

    // kayit sill
    public void deleteBorrow(Long id) {
        borrowsRepository.deleteById(id);
    }
}
