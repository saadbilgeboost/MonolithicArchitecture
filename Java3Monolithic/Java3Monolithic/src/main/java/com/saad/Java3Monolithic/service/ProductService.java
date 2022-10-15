package com.saad.Java3Monolithic.service;

import com.saad.Java3Monolithic.dto.request.ProductSaveRequestDto;
import com.saad.Java3Monolithic.dto.response.ProductGetFindByIdResponseDto;
import com.saad.Java3Monolithic.mapper.ProductMapper;
import com.saad.Java3Monolithic.repository.IProductRepository;
import com.saad.Java3Monolithic.repository.entity.Product;
import com.saad.Java3Monolithic.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product, Long> {
    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }
    public ProductGetFindByIdResponseDto findByIdDto(Long id) {
        Product product = productRepository.getReferenceById(id);
        return ProductGetFindByIdResponseDto.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .model(product.getModel()).build();
    }
    public Product save (ProductSaveRequestDto dto){
            Product product = ProductMapper.INSTANCE.toProduct(dto);
            product.setCreatedate(System.currentTimeMillis());
            product.setIsactive(true);
            productRepository.save(product);
            return product;
        }
    }