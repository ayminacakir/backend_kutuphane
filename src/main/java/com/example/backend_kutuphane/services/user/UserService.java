package com.example.backend_kutuphane.services.user;

import com.example.backend_kutuphane.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository usersRepository;


}
