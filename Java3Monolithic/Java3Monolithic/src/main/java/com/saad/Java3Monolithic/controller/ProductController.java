package com.saad.Java3Monolithic.controller;

import com.saad.Java3Monolithic.dto.request.ProductSaveRequestDto;
import com.saad.Java3Monolithic.dto.response.ProductGetFindByIdResponseDto;
import com.saad.Java3Monolithic.repository.entity.Product;
import com.saad.Java3Monolithic.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.saad.Java3Monolithic.constants.EndPoints.*;

@RestController
@RequestMapping(VERSION+API+PRODUCT)
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @GetMapping(SAVE)
    public String save(String name, String brand, String model, Double price, Integer stock){
        Product product = Product.builder()
                .name(name)
                .brand(brand)
                .model(model)
                .price(price)
                .stock(stock).build();
        productService.save(product);
        return "Product is saved.";
    }
    @GetMapping(PRODUCT_SAVE_DTO)
    public String save (ProductSaveRequestDto dto){
         productService.save(dto);
         return "Product is saved.";
    }
    @GetMapping(GETALL)
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.findAll());
    }
@GetMapping(FINDBYID)
    public ProductGetFindByIdResponseDto getFindByID(Long id){
        return productService.findByIdDto(id);
    }
}
