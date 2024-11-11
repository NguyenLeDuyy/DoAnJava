package uth.edu.backend.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.File;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FlowerRequestDTO {
    Integer id;
    String name;
    Integer price;
    Integer categoryId;
    String categoryName; // không thể tạo mới category từ flower
    String Season;
    String description;
    String imageUrl;
    Integer quantity;
    File image;
}
