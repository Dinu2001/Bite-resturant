package com.Bite_resturant.repo;

import com.Bite_resturant.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Orders,Integer> {


    List<Orders> findAllByUserEmail(String email);

    List<Orders> findAllByOrderDate(Date date);


    Optional<Orders> findByOrderId(int id);
}
