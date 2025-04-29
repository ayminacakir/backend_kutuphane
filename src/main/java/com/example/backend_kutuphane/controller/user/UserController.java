package com.example.backend_kutuphane.controller.user;

import com.example.backend_kutuphane.entity.Users;
import com.example.backend_kutuphane.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        return ResponseEntity.ok(usersService.updateUser(id, updatedUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(usersService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }




}
