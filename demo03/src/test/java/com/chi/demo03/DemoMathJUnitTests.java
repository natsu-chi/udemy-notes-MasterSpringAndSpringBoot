package com.chi.demo03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.chi.demo03.web03.DemoMathJUnit;

public class DemoMathJUnitTests {
    private DemoMathJUnit math = new DemoMathJUnit();

    @Test
    void calculateSumByThreeElementsArray() {
        assertEquals(6, math.calculateSum(new int[] {1, 2, 3}));
    }

    @Test
    void calculateSumByEmptyArray() {
        assertEquals(0, math.calculateSum(new int[] {}));
    }
}
