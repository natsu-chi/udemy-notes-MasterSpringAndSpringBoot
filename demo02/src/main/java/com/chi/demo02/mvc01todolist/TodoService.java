package com.chi.demo02.mvc01todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    // Fake data
    static {
        todos.add(new Todo("usera", "task a", "2024-07-18", true));
        todos.add(new Todo("usera", "task b", "2024-07-18", false));
        todos.add(new Todo("usera", "task c", "2024-07-18", true));
    }

    public List<Todo> findByName(String name) {
        return todos;
    }

    public void addOne(Todo todo) {
        todos.add(todo);
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public boolean updateById(int id, @Valid Todo data) {
        Optional<Todo> todo = todos.stream().filter(t -> t.getId() == id).findFirst();
        // todo.ifPresent(System.out::println);
        try {
            if(todo.isPresent()) {
                todos.set(id-1, data);
            }
            return true;
        } catch(Exception e) {
            System.out.println("update error: "+ e);
            return false;
        }
    }

    public Todo findById(int id) {
        Optional<Todo> todo = todos.stream().filter(t -> t.getId() == id).findFirst();
        return todo.get();
    }
}
