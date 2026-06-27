package com.wipro.srms.util;

public class InvalidStudentException extends Exception {

    @Override
    public String toString() {
        return "Invalid Student ID";
    }
}