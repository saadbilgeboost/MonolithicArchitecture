package com.saad.Java3Monolithic.controller;

import com.saad.Java3Monolithic.dto.response.CustomerFindByIdResponseDto;
import com.saad.Java3Monolithic.repository.entity.Customer;
import com.saad.Java3Monolithic.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.saad.Java3Monolithic.constants.EndPoints.*;

@RestController
@RequestMapping(VERSION+API+CUSTOMER)
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(SAVE)
    public String saveCustomer(String name, String surname, String address){
        Customer customer = Customer.builder()
                .name(name)
                .surname(surname)
                .address(address)
                .build();
        customerService.save(customer);
        return "Customer is registered.";
    }
    @GetMapping(FINDALL)
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerService.findAll());
    }



    @GetMapping(FINDBYID)
    public CustomerFindByIdResponseDto findByIdDto(Long id){
        return customerService.findByIdDto(id);
    }
}

