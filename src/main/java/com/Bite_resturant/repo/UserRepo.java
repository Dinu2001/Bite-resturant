package com.Bite_resturant.repo;

import com.Bite_resturant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User,String> {
    List<User> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String word, String word1);

    User findByEmail(String email);
}
