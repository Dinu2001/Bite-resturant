package com.Bite_resturant.repo;

import com.Bite_resturant.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface FeedbackRepo extends JpaRepository<Feedback,Integer> {
}
