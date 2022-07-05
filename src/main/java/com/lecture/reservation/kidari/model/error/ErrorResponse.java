package com.lecture.reservation.kidari.model.error;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class ErrorResponse {

    private String message;
    private int status;

    public static ErrorResponse of(int errorStatus, String message) {
        return new ErrorResponse(errorStatus,message);
    }

    private ErrorResponse(int errorStatus, String message) {
        this.status = errorStatus;
        this.message = message;
    }

}
