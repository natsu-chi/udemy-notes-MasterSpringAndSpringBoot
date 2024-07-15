package com.chi.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chi.demo02.Person.BloodType;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PersonJpaRepository {

    // @Autowired -> @PersistenceContext: 更精準表達對容器管理的 PersistentManager & 關聯的 PersistantContext
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Person person) {
        // 透過 @Entity Mapping，傳入物件就好，其他框架自己搞定
        entityManager.merge(person);
    }

    public void delete(int id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

}

