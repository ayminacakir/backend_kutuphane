package com.example.backend_kutuphane.services.user;

import com.example.backend_kutuphane.entity.Users;
import com.example.backend_kutuphane.repositories.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    public Users updateUser(Long id, Users updatedUser) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Kullanıcı bulunamadı"));
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setUsername(updatedUser.getUsername());
        user.setRole(updatedUser.getRole());
        return userRepository.save(user);
    }
    public Users getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
    }
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

}
