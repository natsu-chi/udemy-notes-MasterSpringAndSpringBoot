package com.chi.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.chi.demo02.Person.BloodType;

import jakarta.transaction.Transactional;

@Component
@Transactional // JPA 需要加上這個註釋，啟用 transaction（保證資料的一致性和完整性）
public class PersonJpaCommandLineRunner implements CommandLineRunner{

    @Autowired
    private PersonJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Person(1, "John", BloodType.A));
        repository.insert(new Person(2, "Jane", BloodType.B));
        repository.insert(new Person(3, "Jack", BloodType.O));

        repository.delete(2);

        System.out.println(repository.findById(3));
    }


}
