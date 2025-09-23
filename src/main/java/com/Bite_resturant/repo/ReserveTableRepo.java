package com.Bite_resturant.repo;

import com.Bite_resturant.entity.ReserveTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ReserveTableRepo extends JpaRepository<ReserveTable,Integer> {
}
