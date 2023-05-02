package org.example.exception;

public class DuplicateUserID extends Exception {

    public DuplicateUserID(String message) {
        super(message);
    }
}
