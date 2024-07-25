package com.chi.demo03.web01.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public DemoBean filtering() {
        return new DemoBean("value1", "value2", "value3", "value4");
    }

    @GetMapping("/filtering-list")
    public List<DemoBean> filteringList() {
        return Arrays.asList(new DemoBean("value1", "value2", "value3", "value4"), new DemoBean("value5", "value6", "value7", "value8"));
    }

    @GetMapping("filtering-dy")
    public MappingJacksonValue FilteringDy() {
        DynamicDemoBean dynamicDemoBean = new DynamicDemoBean("value1", "value2", "value3", "value4");
        MappingJacksonValue mjv = new MappingJacksonValue(dynamicDemoBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mjv.setFilters(filters);

        return mjv;
    }

    @GetMapping("/filtering-dy-list")
    public MappingJacksonValue filteringDyList() {
        List<DynamicDemoBean> list = Arrays.asList(new DynamicDemoBean("value1", "value2", "value3", "value4"), new DynamicDemoBean("value5", "value6", "value7", "value8"));
        MappingJacksonValue mjv = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mjv.setFilters(filters);

        return mjv;
    }
}
