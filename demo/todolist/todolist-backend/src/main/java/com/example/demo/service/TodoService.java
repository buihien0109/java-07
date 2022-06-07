package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Todo;
import com.example.demo.request.CreateTodoRequest;
import com.example.demo.request.UpdateTodoRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private List<Todo> todos = new ArrayList<>();

    public TodoService() {
        Random rd = new Random();
        todos.add(new Todo(rd.nextInt(1000), "Đi đá bóng", false));
        todos.add(new Todo(rd.nextInt(1000), "Làm bài tập", true));
        todos.add(new Todo(rd.nextInt(1000), "Đi chơi với bạn bè", true));
    }

    public List<Todo> getTodos(String status) {
        return switch (status) {
            case "true" -> todos.stream().filter(Todo::isStatus).collect(Collectors.toList());
            case "false" -> todos.stream().filter(p -> !p.isStatus()).collect(Collectors.toList());
            default -> todos;
        };
    }

    public Todo getTodoById(int id) {
        return todos
                .stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found with id = " + id);
                });
    }

    public Todo createTodo(CreateTodoRequest request) {
        Random rd = new Random();
        Todo todo = new Todo(rd.nextInt(1000), request.getTitle(), false);
        todos.add(todo);
        return todo;
    }

    public Todo updateTodo(int id, UpdateTodoRequest request) {
        Todo todo = getTodoById(id);
        todo.setTitle(request.getTitle());
        todo.setStatus(request.isStatus());

        return todo;
    }

    public void deleteTodo(int id) {
        Todo todo = getTodoById(id);
        todos.remove(todo);
    }
}
