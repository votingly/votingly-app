package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.user.User;
import com.votingly.votingly-app.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByName(String name) {
        return userRepository.findByFirstName(name);
    }

    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
//
//    @Transactional
//    public User addUser(String firstName, String lastName, String email, String password){
////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////        String encodedPassword = passwordEncoder.encode(password);
//        var user = new User(firstName, lastName, email, password);
//        var savedUser = userRepository.save(user);
//        return savedUser;
//    }

    public User addUser(String firstName, String lastName, String email, String password) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        return userRepository.save(user);
    }

}
