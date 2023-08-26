package io.avijeet.springtodobackend.controller;

import io.avijeet.springtodobackend.dto.ToDoDto;
import io.avijeet.springtodobackend.payload.ApiResponse;
import io.avijeet.springtodobackend.services.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setMessage("Todo created");
            apiResponse.setError(false);
            apiResponse.setData(createdTodo);
            return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            ApiResponse errorResponse = new ApiResponse();
            errorResponse.setError(true);
            errorResponse.setMessage("Oops something went wrong");
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // Mapping to update todo
    // Mapping to delete todo
    // Mapping to list all todos
}
