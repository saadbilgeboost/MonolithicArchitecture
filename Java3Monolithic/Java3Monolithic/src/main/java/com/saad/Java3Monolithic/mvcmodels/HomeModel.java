package com.saad.Java3Monolithic.mvcmodels;

import com.saad.Java3Monolithic.repository.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HomeModel {
    String title;
    List<String> menu;
    String username;
    String avatar;
    List<Product> products;
}

