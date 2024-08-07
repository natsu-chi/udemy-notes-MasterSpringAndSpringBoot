package com.example.demo06.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo06.data.Data2Service;

@Service
public class Business2Service {
    
    private Data2Service data2Service;

    public Business2Service(Data2Service data2Service) {
        this.data2Service = data2Service;
    }

    public int calculateMin() {
        int[] data = data2Service.retrieveAllData();
        return Arrays.stream(data).min().orElse(0);
    }

}
