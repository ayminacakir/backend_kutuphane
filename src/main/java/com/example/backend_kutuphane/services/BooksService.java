package com.example.backend_kutuphane.services;

import com.example.backend_kutuphane.dto.BooksDTO;
import com.example.backend_kutuphane.entity.Books;
import com.example.backend_kutuphane.entity.enums.State;
import com.example.backend_kutuphane.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public BooksDTO getBookById(Long id) {
        Books book = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        return new BooksDTO(book.getId(), book.getTitle(), book.getAuthor(),
                book.getCategories().getName(), book.getStates());
    }

    public List<BooksDTO> getAllBooks() {
        List<Books> books = booksRepository.findAll();
        return books.stream()
                .map(book -> new BooksDTO(book.getId(), book.getTitle(), book.getAuthor(),
                        book.getCategories().getName(), book.getStates()))
                .collect(Collectors.toList());
    }

    public List<BooksDTO> getBooksByStatus(State status) {
        List<Books> books = booksRepository.findByStates(status);
        return books.stream()
                .map(book -> new BooksDTO(book.getId(), book.getTitle(), book.getAuthor(),
                        book.getCategories().getName(), book.getStates()))
                .collect(Collectors.toList());
    }

    public List<BooksDTO> getBooksByAuthor(String author) {
        List<Books> books = booksRepository.findByAuthorContainingIgnoreCase(author);
        return books.stream()
                .map(book -> new BooksDTO(book.getId(), book.getTitle(), book.getAuthor(),
                        book.getCategories().getName(), book.getStates()))
                .collect(Collectors.toList());
    }

    public void addBook(Books book) {
        booksRepository.save(book);
    }

    public void updateBook(Long id, Books updatedBook) {
        Books book = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setCategories(updatedBook.getCategories());
        book.setStates(updatedBook.getStates());
        booksRepository.save(book);
    }

    public void deleteBook(Long id) {
        booksRepository.deleteById(id);
    }
}

