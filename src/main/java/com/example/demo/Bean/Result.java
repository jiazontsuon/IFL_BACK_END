package com.example.demo.Bean;

public class Result<T> {

    /**
     * state code
     */
    private String status;

    /**
     * request for status 
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * state info, error info
     */
    private String message;

    /**
     * get message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * data
     */
    private T data;

    /**
     * get data
     *
     * @return data
     */
    public T getData() {
        return data;
    }

    private Result(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private Result(String status, String message) {
        this.status = status;
        this.message = message;
    }

    private Result(String message) {
        this.message = message;
    }

    public static <T> Result<T> buildResult(Status status, String message, T data) {
        return new Result<T>(status.getCode(), message, data);
    }


    public static <T> Result<T> buildResult(Status status, String message) {
        return new Result<T>(status.getCode(), message);
    }


    public static <T> Result<T> buildResult(Status status, T data) {
        return new Result<T>(status.getCode(), status.getReason(), data);
    }

    public static <T> Result<T> buildResult(Status status) {
        return new Result<T>(status.getCode(), status.getReason());
    }
}

