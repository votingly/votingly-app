package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.user.RegularUser;
import com.votingly.votingly-app.model.user.User;
import com.votingly.votingly-app.repositories.RegularUserRepository;
import com.votingly.votingly-app.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final RegularUserRepository regularUserRepository;
    private final UserRepository userRepository;

    public UserService(RegularUserRepository regularUserRepository, UserRepository userRepository) {
        this.regularUserRepository = regularUserRepository;
        this.userRepository = userRepository;
    }

    public RegularUser getUserByName(String name) {
        return regularUserRepository.findByFirstName(name);
    }

    public User getUserById(long id) {
        return userRepository.findById(id);
    }
}
