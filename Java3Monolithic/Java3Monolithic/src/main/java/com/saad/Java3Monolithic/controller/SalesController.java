package com.saad.Java3Monolithic.controller;


import com.saad.Java3Monolithic.exception.ErrorType;
import com.saad.Java3Monolithic.exception.MonolithicManagerException;
import com.saad.Java3Monolithic.repository.entity.Sales;
import com.saad.Java3Monolithic.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.saad.Java3Monolithic.constants.EndPoints.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(VERSION+API+SALES)
public class SalesController {
    private final SalesService salesService;
    @GetMapping(SAVE)
    public String save(Long customerId, Long productId,Double quantity, Double price, Double totalPrice, Long date){
        Sales sales = Sales.builder()
                .customerId(customerId)
                .productId(productId)
                .quantity(quantity)
                .price(price)
                .totalPrice(totalPrice)
                .date(date)
                .build();
        salesService.save(sales);
        return "Sales data saved.";
    }
    @GetMapping(GETALL)
    public ResponseEntity<List<Sales>> getAll(){
        return ResponseEntity.ok(salesService.findAll());
    }
    @GetMapping("/error")
    public String createError(){
        throw new MonolithicManagerException(ErrorType.ADD_SALES_PROBLEM);
    }
}
