package uth.edu.backend.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

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
    FileDTO image;
    LocalDate createdDate;
    LocalDate lastModifiedDate;

    @Data
    public static class FileDTO {
        private String name;
        private long lastModified;
        private String lastModifiedDate;
        private String webkitRelativePath;
        private long size;

    }
}
