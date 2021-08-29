package com.example.studentservice.exceptions;
/**
 * StudentNotFoundException
 * This exception means that searching studentUuid not found in DB
 */
public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message)
    {
        super(message);
    }
}
