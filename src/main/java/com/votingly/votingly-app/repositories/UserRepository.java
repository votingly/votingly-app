package com.votingly.votingly-app.repositories;

import com.votingly.votingly-app.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    User findByFirstName(String firstName);

//    @Query("SELECT u FROM User u WHERE u.email = ?1")
//    public User findByEmail(String email);

}
