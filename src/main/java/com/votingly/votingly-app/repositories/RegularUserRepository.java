package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.user.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {
    RegularUser findByFirstName(String name);
}
