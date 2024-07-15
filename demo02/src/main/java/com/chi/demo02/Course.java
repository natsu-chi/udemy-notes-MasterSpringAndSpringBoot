package com.chi.demo02;

// Model used for Spring JDBC
public class Course {
    public static int cnt = 2; // 配合 CourseJdbcCommandLineRunner 的 query 先設 2，一般從 0 開始
    private String courseName;
    private String courseCode;

    Course() {}

    Course(String courseName, String courseCode) {
        cnt++;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}