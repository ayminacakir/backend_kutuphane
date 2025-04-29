package com.example.backend_kutuphane.controller.user;

import com.example.backend_kutuphane.entity.Users;
import com.example.backend_kutuphane.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    // Kullanıcı işlemleri için gerekli metodlar burada tanımlanacak
    // Örnek: kullanıcı ekleme, güncelleme, silme, listeleme vb.
    // Bu sınıfın içeriği, uygulamanızın gereksinimlerine göre değişebilir.


    private UserService usersService;

    @PostMapping("/register")   // http://localhost:8081/user/register
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> saveUser(Users user) {
        return ResponseEntity.ok(usersService.saveUser(user));
    }

    // deleteUser  ^******************************


    // updateUser  ^******************************


    // getUserById  ^******************************


    // getAllUsers  ^******************************









}
