package com.chi.demo02;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ReviewDataJpaRepository extends JpaRepository<Review, Long>{

    // Spring Data JPA 優點: 更彈性的方法宣告
    List<Review> findByContent(String content);

}

