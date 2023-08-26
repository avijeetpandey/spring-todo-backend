package io.avijeet.springtodobackend.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {
    private boolean isError;
    private String message;
    private T data;
}
