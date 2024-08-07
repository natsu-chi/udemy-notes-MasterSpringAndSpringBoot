package com.example.demo06.data;

import org.springframework.stereotype.Repository;

@Repository
public class Data1Service {

    public int[] retrieveAllData() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[] { 1, 2, 3, 4 };
    }

}