package uth.edu.backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uth.edu.backend.entity.Cart;
import uth.edu.backend.entity.Order;
import uth.edu.backend.entity.UserDetail;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    private Long id;
    String username;
    String password;
    String email;
    String phoneNumber;
    Integer role = 0; // Set default value to 0
    Cart cart;
    Set<Order> orders = new LinkedHashSet<>();
    Set<UserDetail> userDetails = new LinkedHashSet<>();
}
