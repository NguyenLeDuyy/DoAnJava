package uth.edu.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import uth.edu.backend.dto.request.UserCreationRequest;
import uth.edu.backend.dto.request.UserUpdateRequest;
import uth.edu.backend.dto.response.UserResponse;
import uth.edu.backend.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
