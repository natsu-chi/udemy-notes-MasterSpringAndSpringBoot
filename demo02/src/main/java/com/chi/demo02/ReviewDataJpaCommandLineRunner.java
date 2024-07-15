package com.chi.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReviewDataJpaCommandLineRunner implements CommandLineRunner{

    @Autowired
    private ReviewDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Review(1, 1, "Good!"));
        repository.save(new Review(2, 3, "Ummm!"));
        repository.save(new Review(3, 1, "Great!"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());

        // Spring Data JPA 優點: 更彈性的方法宣告
        System.out.println(repository.findByContent("Good!"));
        System.out.println(repository.findByContent("Great!"));
    }

}

