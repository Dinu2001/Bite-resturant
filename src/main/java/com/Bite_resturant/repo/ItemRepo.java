package com.Bite_resturant.repo;

import com.Bite_resturant.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item,String> {
    Optional<Item> findByItemCode(String code);
    void deleteByItemCode(String code);
    List<Item> findAllByItemNameStartingWithIgnoreCase(String name);
}
