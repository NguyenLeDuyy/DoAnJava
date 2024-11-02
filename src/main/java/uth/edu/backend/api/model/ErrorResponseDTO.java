package uth.edu.backend.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import uth.edu.backend.customexception.ErrorCode;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
    private ErrorCode errorCode;
    private List<String> details;
}
