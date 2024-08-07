package com.chi.demo03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.chi.demo03.web03.*;

// Mock 寫法
@ExtendWith(MockitoExtension.class)
public class DemoServiceMockitoMockTests {

    @Mock
    private DataRepository dataMock;

    @InjectMocks
    private DemoServiceMockito service;

    @Test
    void getMaxValueByThreeElementsArray() {
        when(dataMock.retrieveAllData()).thenReturn(new int[]{20, 30, 50});
        int max = service.getMaxValueFromData();
        assertEquals(50, max);
    }

    @Test
    void getMaxValueByOneElementArray() {
        when(dataMock.retrieveAllData()).thenReturn(new int[]{10});
        int max = service.getMaxValueFromData();
        assertEquals(10, max);
    }

    @Test
    void getMaxValueByEmptyArray() {
        when(dataMock.retrieveAllData()).thenReturn(new int[]{});
        int max = service.getMaxValueFromData();
        assertEquals(Integer.MIN_VALUE, max);
    }

}