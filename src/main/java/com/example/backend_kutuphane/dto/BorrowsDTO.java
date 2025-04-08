package com.example.backend_kutuphane.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowsDTO {
    private Long id;
    private Long bookId;
    private Long userId;
    private String bookTitle;
    private LocalDate borrowDate;
    private LocalDate returnDate;


}
