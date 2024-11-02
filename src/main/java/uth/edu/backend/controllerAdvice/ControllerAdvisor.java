package uth.edu.backend.controllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uth.edu.backend.customexception.AppException;
import uth.edu.backend.customexception.FieldRequiredException;
import uth.edu.backend.dto.request.ApiResponse;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(
            ArithmeticException ex, WebRequest request) {

        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setCode(null);
        apiResponse.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("Số nguyên làm sao mà chia cho 0 được");
        apiResponse.setDetails(details);

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(
            FieldRequiredException ex, WebRequest request) {

        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setCode(null);
        apiResponse.setError(ex.getMessage());
        List<String> details = new ArrayList<>();
        details.add("Check lại name, price, category của hoa");
        apiResponse.setDetails(details);

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> handleAppException(
            AppException ex, WebRequest request) {

        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setCode(ex.getErrorCode().getCode());
        apiResponse.setError(ex.getErrorCode().toString());
        List<String> details = new ArrayList<>();
        details.add("Check lại thông tin đầu vào");
        apiResponse.setDetails(details);

        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_GATEWAY);
    }

}