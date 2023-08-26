package io.avijeet.springtodobackend.controller;

import io.avijeet.springtodobackend.dto.ToDoDto;
import io.avijeet.springtodobackend.payload.ApiResponse;
import io.avijeet.springtodobackend.services.TodoService;
import io.avijeet.springtodobackend.utils.ApiResponseHandler;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    // Properties
    @Autowired
    private TodoService todoService;

    @Autowired
    private ModelMapper modelMapper;

    // Mapping to create todo
    @PostMapping("/")
    public ResponseEntity<ApiResponse> createTodo(@RequestBody ToDoDto toDoDto) {
        try {
            ToDoDto createdTodo = this.todoService.createTodo(toDoDto);
            return new ApiResponseHandler<>(createdTodo).handleSuccess();
        } catch (Exception ex) {
            return new ApiResponseHandler<>(ex.getMessage()).handleError();
        }
    }
    // Mapping to update todo
    @PutMapping("/{todoId}")
    public ResponseEntity<ApiResponse> updateTodo(@PathVariable String todoId,
                                                  @RequestBody ToDoDto toDoDto) {
        try {
            ToDoDto updatedTodo = this.todoService.updateTodo(toDoDto, Long.parseLong(todoId));
            return new ApiResponseHandler<>(updatedTodo).handleSuccess();
        } catch (Exception ex) {
            return new ApiResponseHandler<>(ex.getMessage()).handleError();
        }
    }

    // Mapping to delete todo
    @DeleteMapping("/{todoId}")
    public ResponseEntity<ApiResponse> deleteTodo(@PathVariable String todoId) {
        try {
            ToDoDto deletedTodo = this.todoService.deleteTodo(Long.parseLong(todoId));
            return new ApiResponseHandler<>(deletedTodo.getId()).handleSuccess();
        } catch (Exception ex) {
            return new ApiResponseHandler<>(ex.getMessage()).handleError();
        }
    }

    // Mapping to list all todos
    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllTodos() {
        try {
            List<ToDoDto> allTodos = this.todoService.getAllTodos();
            return new ApiResponseHandler<>(allTodos).handleSuccess();
        } catch (Exception ex) {
            return new ApiResponseHandler<>(ex.getMessage()).handleError();
        }
    }
}
