package com.chi.demo03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import com.chi.demo03.web03.*;

// Stub 寫法
public class DemoServiceMockitoStubTests {

    @Test
    void getMaxValueByThreeElementsArray() {
        DataRepository dataStub1 = new DataRepositoryStub1();
        DemoServiceMockito service = new DemoServiceMockito(dataStub1);
        int max = service.getMaxValueFromData();
        assertEquals(50, max);
    }

    @Test
    void getMaxValueByOneElementArray() {
        DataRepository dataStub2 = new DataRepositoryStub2();
        DemoServiceMockito service = new DemoServiceMockito(dataStub2);
        int max = service.getMaxValueFromData();
        assertEquals(10, max);
    }

}


class DataRepositoryStub1 implements DataRepository {

    @Override
    public int[] retrieveAllData() {
        return new int[]{20, 30, 50};
    }
}

class DataRepositoryStub2 implements DataRepository {

    @Override
    public int[] retrieveAllData() {
        return new int[]{10};
    }
}

class DataRepositoryStub3 implements DataRepository {

    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}