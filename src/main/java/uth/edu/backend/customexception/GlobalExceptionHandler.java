package uth.edu.backend.customexception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uth.edu.backend.dto.request.ApiResponse;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception){
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        List<String> details = List.of(exception.getMessage());
        details.add(exception.getMessage());
        apiResponse.setDetails(details);

        return ResponseEntity.badRequest().body(apiResponse); //Thường lỗi dữ liệu từ ng dùng là loi~ 400 <=> bad request
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception){
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        List<String> details = List.of(exception.getMessage());
        apiResponse.setDetails(details);

        return ResponseEntity.badRequest().body(apiResponse); //Thường lỗi dữ liệu từ ng dùng là loi~ 400 <=> bad request
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        String enumKey = exception.getFieldError().getDefaultMessage();

        ErrorCode errorCode = ErrorCode.INVALID_KEY;

        try {
            errorCode = ErrorCode.valueOf(enumKey);
        }
        catch (IllegalArgumentException e){
        }

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        List<String> details = List.of(exception.getFieldError().getDefaultMessage());
        apiResponse.setDetails(details);

        return ResponseEntity.badRequest().body(apiResponse);
    }

}
