package com.company.challenge.model;

public class RestApiResult<T> {

    private T result;
    private String error;

    public RestApiResult() {}

    public RestApiResult(String error, T result) {
        this.error = error;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}
