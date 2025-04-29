package com.example.backend_kutuphane.payload.request;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {

    @NotBlank(message = "Please Provide Username")
    private String username;

    @NotBlank(message = "Please Provide Old Password")
    private String oldPassword;

    @NotBlank(message = "Please Provide New Password")
    private String newPassword;
}
