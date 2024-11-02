package uth.edu.backend.customexception;

public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized exception"),
    INVALID_KEY(1001, "Invalid message key"),
    USER_EXISTED(1002, "User existed"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters"),
    FLOWER_NAME_INVALID(1005, "Flower's name must be not null"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters"),
    FLOWER_PRICE_INVALID(1006, "Flower's price must be greater than 0 or not null")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
