package io.avijeet.springtodobackend.repository;

import io.avijeet.springtodobackend.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<Todo, Long> {
}
