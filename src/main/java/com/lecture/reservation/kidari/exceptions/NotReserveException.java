package com.lecture.reservation.kidari.exceptions;

public class NotReserveException extends IllegalStateException{

    public NotReserveException(String message){
        super(message);
    }
}
