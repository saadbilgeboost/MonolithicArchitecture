package com.saad.Java3Monolithic.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductSaveRequestDto {
    String name;
    String brand;
    String model;
    String price;
    Integer stock;
}
