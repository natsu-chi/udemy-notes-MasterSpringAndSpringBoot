package com.chi.demo03.web02;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Word, Integer> {
}
