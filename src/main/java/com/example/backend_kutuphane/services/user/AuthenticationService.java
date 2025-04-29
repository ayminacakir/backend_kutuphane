package com.example.backend_kutuphane.services.user;

import com.example.backend_kutuphane.entity.Users;
import com.example.backend_kutuphane.payload.request.LoginRequest;
import com.example.backend_kutuphane.payload.response.AuthResponse;
import com.example.backend_kutuphane.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    /**
     * Login işlemi: DTO alır, kullanıcıyı veritabanında arar ve eşleşme varsa kullanıcı bilgilerini döner.
     */
    public ResponseEntity<AuthResponse> authenticateUser(LoginRequest loginRequest) throws BadRequestException {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Users user = userRepository.findByUsernameEquals(username)
                .orElseThrow(() -> new BadRequestException("Kullanıcı bulunamadı"));

        if (!user.getPassword().equals(password)) {
            throw new BadRequestException("Şifre hatalı");
        }

        AuthResponse authResponse = AuthResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .role(user.getRole().name())
                .build();

        return ResponseEntity.ok(authResponse);
    }


    public void updatePassword(String username, String oldPassword, String newPassword) throws BadRequestException {
        Users user = userRepository.findByUsernameEquals(username)
                .orElseThrow(() -> new BadRequestException("Kullanıcı bulunamadı"));

        if (!user.getPassword().equals(oldPassword)) {
            throw new BadRequestException("Mevcut şifre yanlış");
        }

        user.setPassword(newPassword);
        userRepository.save(user);
    }


}

