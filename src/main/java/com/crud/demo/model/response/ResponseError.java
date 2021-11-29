package com.crud.demo.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Class that implements a generic response error object to the API endpoints.
 *
 * @author Mariana Azevedo
 * @since 01/04/2020
 */
@Getter
@Setter
@Accessors(chain = true)
public class ResponseError {

    @NotNull(message = "Timestamp cannot be null")
    private LocalDateTime timestamp;

    @NotNull(message = "Details cannot be null")
    private String details;


    public ResponseError(@NotNull(message = "Timestamp cannot be null") LocalDateTime timestamp,
                         @NotNull(message = "Details cannot be null") String details) {
        this.timestamp = timestamp;
        this.details = details;
    }

    public ResponseError() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


}