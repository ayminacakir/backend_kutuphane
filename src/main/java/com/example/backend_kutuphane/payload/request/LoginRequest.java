package com.example.backend_kutuphane.payload.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    @NotBlank(message = "Username must be not empty")
    private String username;
    @NotBlank(message = "Password must be not empty")
    private String password;

}
