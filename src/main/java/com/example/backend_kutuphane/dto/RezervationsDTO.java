package com.example.backend_kutuphane.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RezervationsDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private String bookTitle;
    private LocalDate reservationDate;
}
