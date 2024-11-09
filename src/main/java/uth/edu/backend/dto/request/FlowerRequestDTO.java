package uth.edu.backend.dto.request;

import lombok.Data;

@Data
public class FlowerRequestDTO {
    private Integer id;
    private String name;
    private Integer price;
    private Integer categoryId;
    private String categoryName; // không thể tạo mới category từ flower
    private String Season;
    private String description;
    private String imageUrl;
    private Integer quantity;
}
