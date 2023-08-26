package io.avijeet.springtodobackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ToDoDto {
    private long id;
    private String title;
    private Date createdAt;
    private boolean isCompleted;
}
