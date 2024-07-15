package com.chi.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception{
        repository.insertHardcoded();
        repository.insert(2, "Class A", "CA");
        repository.insertByObj(new Course("Class B", "CB"));
        repository.insertByObj(new Course("Class C", "CC"));

        repository.delete(2);
        System.out.println(repository.findById(3));

    }
}