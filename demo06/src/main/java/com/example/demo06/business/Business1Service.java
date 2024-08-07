package com.example.demo06.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.example.demo06.annotations.Tracktime;
import com.example.demo06.data.Data1Service;

@Service
public class Business1Service {
    
    private Data1Service data1Service;

    public Business1Service(Data1Service data1Service) {
        this.data1Service = data1Service;
    }

    @Tracktime
    public int calculateMax() {
        int[] data = data1Service.retrieveAllData();
        return Arrays.stream(data).max().orElse(0);
    }

}
