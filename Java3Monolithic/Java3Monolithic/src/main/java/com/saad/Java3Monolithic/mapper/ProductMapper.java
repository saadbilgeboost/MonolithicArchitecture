package com.saad.Java3Monolithic.mapper;

import com.saad.Java3Monolithic.dto.request.ProductSaveRequestDto;
import com.saad.Java3Monolithic.dto.response.ProductGetFindByIdResponseDto;
import com.saad.Java3Monolithic.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductGetFindByIdResponseDto toProductGetFindByIdResponseDto(final Product product);
    Product toProduct(final ProductSaveRequestDto dto);
}
