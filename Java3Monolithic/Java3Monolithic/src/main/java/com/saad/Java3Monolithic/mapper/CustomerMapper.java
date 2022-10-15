package com.saad.Java3Monolithic.mapper;

import com.saad.Java3Monolithic.dto.response.CustomerFindByIdResponseDto;
import com.saad.Java3Monolithic.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerFindByIdResponseDto toCustomerFindByIdResponseDto(final Customer customer);
    Customer toCustomer(final CustomerFindByIdResponseDto dto);

}
