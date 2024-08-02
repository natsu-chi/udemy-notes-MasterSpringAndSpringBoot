package com.chi.demo03.web03;

public class DemoMathJUnit {
    
    // (1+2+3) => 1+2+3 = 6
    public int calculateSum(int[] nums) {
        
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        return sum;
    }
}
