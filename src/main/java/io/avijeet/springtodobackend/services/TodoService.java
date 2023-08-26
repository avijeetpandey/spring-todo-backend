package io.avijeet.springtodobackend.services;

import io.avijeet.springtodobackend.dto.ToDoDto;
import io.avijeet.springtodobackend.entity.Todo;

import java.util.List;

public interface TodoService {
    ToDoDto createTodo(ToDoDto todoDto);
    ToDoDto updateTodo(ToDoDto toDoDto, long todoId);
    ToDoDto deleteTodo(long todoId);
    List<ToDoDto> getAllTodos();
}
