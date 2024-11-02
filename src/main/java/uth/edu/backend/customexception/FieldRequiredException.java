package uth.edu.backend.customexception;

public class FieldRequiredException extends RuntimeException{
    public FieldRequiredException(String s) {
        super(s);
    }
}
