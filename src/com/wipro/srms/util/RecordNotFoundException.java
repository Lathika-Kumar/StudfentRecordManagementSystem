package com.wipro.srms.util;

public class RecordNotFoundException extends Exception {

    @Override
    public String toString() {
        return "Record Not Found";
    }
}