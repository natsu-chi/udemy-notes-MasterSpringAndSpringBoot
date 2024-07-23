package com.chi.demo02.mvc01todolist;

import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class Todo {

    private static int cnt = 0;
    private int id;
    private String name;
    private String date;
    @Size(min = 10, message = "Enter at least 10 characters!")
    private String title;
    private boolean isDone;


    public Todo() {}

    public Todo(String name, String title, String date, boolean isDone) {
        cnt++;
        this.id = cnt;
        this.name = name;
        this.date = date;
        this.title = title;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", date=" + date + ", title=" + title + ", isDone=" + isDone + "]";
    }

}
