package com.chi.demo02;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
//        return List.of(
//            new Course("Learn AWS", "10001"),
//            new Course("Learn Spring Boot", "10002")
//        );

        return Arrays.asList(
                new Course("Learn AWS", "10001"),
                new Course("Learn Spring Boot", "10002")
        );


    }


}
