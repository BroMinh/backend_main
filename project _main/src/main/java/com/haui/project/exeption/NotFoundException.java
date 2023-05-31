package com.haui.project.exeption;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}