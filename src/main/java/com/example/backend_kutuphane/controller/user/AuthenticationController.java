package com.example.backend_kutuphane.controller.user;

import com.example.backend_kutuphane.payload.request.LoginRequest;
import com.example.backend_kutuphane.payload.request.UpdatePasswordRequest;
import com.example.backend_kutuphane.payload.response.AuthResponse;
import com.example.backend_kutuphane.services.user.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse response = authenticationService.authenticateUser(loginRequest).getBody();
            return ResponseEntity.ok(response);
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        try {
            authenticationService.updatePassword(
                    updatePasswordRequest.getUsername(),
                    updatePasswordRequest.getOldPassword(),
                    updatePasswordRequest.getNewPassword()
            );
            return ResponseEntity.ok("Password updated successfully");
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
