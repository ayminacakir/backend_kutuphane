package com.example.backend_kutuphane.controller.user;

import com.example.backend_kutuphane.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    // Kullanıcı işlemleri için gerekli metodlar burada tanımlanacak
    // Örnek: kullanıcı ekleme, güncelleme, silme, listeleme vb.
    // Bu sınıfın içeriği, uygulamanızın gereksinimlerine göre değişebilir.


    private UserService usersService;



}
