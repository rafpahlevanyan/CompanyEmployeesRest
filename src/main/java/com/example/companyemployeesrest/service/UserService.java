package com.example.companyemployeesrest.service;

import com.example.companyemployeesrest.entity.User;
import com.example.companyemployeesrest.entity.UserRole;
import com.example.companyemployeesrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {


//    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    public User save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserRole(UserRole.USER);
        return userRepository.save(user);
    }

    public boolean existsById(int id){
        return userRepository.existsById(id);
    }



    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User getById(int id) {
        return userRepository.getById(id);
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findByToken(String token) {
        return userRepository.findByToken(token);
    }
}
