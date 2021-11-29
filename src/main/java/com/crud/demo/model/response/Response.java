package com.crud.demo.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private T data;
    private Object errors;
    private boolean success;

    public Response() {
    }

    public Response(T data) {
        this.data = data;
    }

    public static Response status(boolean status) {
        Response response = new Response();
        response.setSuccess(status);
        return response;
    }

    public void addErrorMsgToResponse(String msgError) {
        ResponseError error = new ResponseError(LocalDateTime.now(), msgError);
        setErrors(error);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object error) {
        this.errors = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
