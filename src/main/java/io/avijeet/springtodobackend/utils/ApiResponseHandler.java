package io.avijeet.springtodobackend.utils;

import io.avijeet.springtodobackend.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseHandler<T> {

    private T data;

    // constructor
    public ApiResponseHandler(T data) {
        this.data = data;
    }

    public ResponseEntity<ApiResponse> handleSuccess() {
        ApiResponse successResponse = new ApiResponse();
        successResponse.setData(this.data);
        successResponse.setError(false);
        successResponse.setMessage(Constants.SUCCESS_MESSAGE);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }

    public ResponseEntity<ApiResponse> handleError() {
        ApiResponse errorResponse = new ApiResponse();
        errorResponse.setMessage(Constants.ERROR_MESSAGE);
        errorResponse.setError(true);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
