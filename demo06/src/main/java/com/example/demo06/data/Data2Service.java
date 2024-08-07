package com.example.demo06.data;

import org.springframework.stereotype.Repository;

@Repository
public class Data2Service {

    public int[] retrieveAllData() {
        return new int[] { 11, 22, 33, 44 };
    }

}