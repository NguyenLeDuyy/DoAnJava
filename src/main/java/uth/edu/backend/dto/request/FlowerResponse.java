package uth.edu.backend.dto.request;

import lombok.Data;

@Data
public class FlowerResponse extends ApiResponse{
    private Integer priceToSeason;
}
