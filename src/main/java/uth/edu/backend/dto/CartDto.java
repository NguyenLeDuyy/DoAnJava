package uth.edu.backend.dto;

import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)

public class CartDto {
    private Long cartId;
    private Long userId;
//    private List<CartDetailDto> cartDetails;
    private 
    double total;
}
