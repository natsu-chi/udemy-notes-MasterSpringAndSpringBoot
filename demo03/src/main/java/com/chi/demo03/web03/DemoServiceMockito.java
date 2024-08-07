package com.chi.demo03.web03;

public class DemoServiceMockito {

    private DataRepository dataRepository;
    
    public DemoServiceMockito(DataRepository dataRepository) {
        super();
        this.dataRepository = dataRepository;
    }
    
    // some bussiness implementation
    public int getMaxValueFromData() {
        int max = Integer.MIN_VALUE;
        var data = dataRepository.retrieveAllData();
        for(int num : data) {
            if(max < num) max = num;
        }
        return max;
    }
}