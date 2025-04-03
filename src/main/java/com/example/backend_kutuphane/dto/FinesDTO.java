package com.example.backend_kutuphane.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FinesDTO {
    private Long id;
    private Long userId;
    private Double amount;
    private boolean paid;
}
