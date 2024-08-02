package com.chi.demo03;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class DemoAssertTest {


    List<String> elemsArray = Arrays.asList("elem1", "elem2", "elem3");

    @Test
    void assertTests() {
        boolean isContained = elemsArray.contains("elem1");
        boolean isContained2 = elemsArray.contains("elem4");
        
        assertEquals(isContained, true);
        
        assertTrue(isContained);
        assertFalse(isContained2);

        assertNull(null);
        assertNotNull(elemsArray);
        
        assertArrayEquals(new int[] {1, 2}, new int[] {2, 1});
    }

    // before, after (依照時間順序)

    @BeforeAll
    void beforeAll() {
        System.out.println("beforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @Test
    void mytest() {
        System.out.println("test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @AfterAll
    void afterAll() {
        System.out.println("afterAll");
    }
}
