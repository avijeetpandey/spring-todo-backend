package io.avijeet.springtodobackend.services.impl;

import io.avijeet.springtodobackend.dto.ToDoDto;
import io.avijeet.springtodobackend.entity.Todo;
import io.avijeet.springtodobackend.exceptions.ResourceNotFoundException;
import io.avijeet.springtodobackend.repository.ToDoRepo;
import io.avijeet.springtodobackend.services.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService  {
    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ToDoDto createTodo(ToDoDto todoDto) {
        Todo todo = this.modelMapper.map(todoDto, Todo.class);
        todo.setCreatedAt(new Date());
        todo.setCompleted(false);
        Todo savedTodo = this.toDoRepo.save(todo);
        return this.modelMapper.map(savedTodo, ToDoDto.class);
    }

    @Override
    public ToDoDto updateTodo(ToDoDto toDoDto, long todoId) {
        return null;
    }

    @Override
    public ToDoDto deleteTodo(long todoId) {
        Todo todo = this.toDoRepo.findById(todoId)
                .orElseThrow(()-> new ResourceNotFoundException("Todo","id",todoId));
        this.toDoRepo.delete(todo);
        return this.modelMapper.map(todo, ToDoDto.class);
    }

    @Override
    public List<ToDoDto> getAllTodos() {
        return this.toDoRepo.findAll()
                .stream()
                .map(todo-> this.modelMapper.map(todo, ToDoDto.class))
                .collect(Collectors.toList());
    }
}
