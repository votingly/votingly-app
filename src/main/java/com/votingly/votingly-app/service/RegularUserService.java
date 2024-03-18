package com.votingly.votingly-app.service;

import com.votingly.votingly-app.model.user.RegularUser;
import com.votingly.votingly-app.repositories.RegularUserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegularUserService {
    private final RegularUserRepository userRepository;

    public RegularUserService(RegularUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegularUser getUserByName(String name) {
        return userRepository.findByFirstName(name);
    }
}
