package com.Bite_resturant.repo;

import com.Bite_resturant.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
    List<Reservation> findAllByUserEmail(String email);
}
