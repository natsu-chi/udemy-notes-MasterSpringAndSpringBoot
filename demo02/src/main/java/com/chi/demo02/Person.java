package com.chi.demo02;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Model used for JPA
// @Entity // 表示這個類別會對到一個 table，如果資料表與 Entity 名稱不同，需加 name
@Entity(name = "person_detail")
public class Person {
    @Id
    private long id;

    // 同名 column 的三種寫法:
    // 1: (省略不註解)
    // 2: @Column
    // 3: @Column(name = "name")
    private String name;

    // 不同名 column 需註解
    @Column(name = "blood_type")
    private BloodType bloodType;

    public enum BloodType {
        A, B, O, AB
    }

    public Person() {}

    public Person(long id, String name, BloodType bloodType) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    };


}

