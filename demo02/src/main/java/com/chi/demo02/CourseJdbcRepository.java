package com.chi.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    static String INSERT_HARDCODED_QUERY = "insert into course (id, course_name, course_code) values (1, 'class a', 'ca');";
    static String INSERT_QUERY = "insert into course (id, course_name, course_code) values (?, ?, ?);";
    static String DELETE_QUERY = "delete from course where id = ?;";
    private static String SELECT_QUERY = "select * from course where id = ?;";

    // 基本 insert 的三種寫法: hardcoded query, by params, by object
    public void insertHardcoded() {
        springJdbcTemplate.update(INSERT_HARDCODED_QUERY);
    }

    public void insert(int id, String courseName, String courseCode) {
        springJdbcTemplate.update(INSERT_QUERY, id, courseName, courseCode);
    }

    public void insertByObj(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, Course.cnt, course.getCourseName(), course.getCourseCode());
    }


    public void delete(int id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(int id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
