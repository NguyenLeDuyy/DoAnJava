package uth.edu.backend.api.model;

import lombok.Data;

@Data
public class FlowerDTO {
    private String name;
    private Integer price;
    private Integer category;
    private String priceToSeason;
}
