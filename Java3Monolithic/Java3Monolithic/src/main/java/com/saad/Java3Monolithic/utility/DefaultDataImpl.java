package com.saad.Java3Monolithic.utility;

import com.saad.Java3Monolithic.repository.entity.Customer;
import com.saad.Java3Monolithic.repository.entity.Product;
import com.saad.Java3Monolithic.service.CustomerService;
import com.saad.Java3Monolithic.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
/**
 * Uyglama ayağa kalarken veritabanına default verileri eklemek için kullanılır.
 * ancak bu sınıfın otomatik çalışması gerekecek.
 */
@RequiredArgsConstructor
@Component
public class DefaultDataImpl {

    private final CustomerService customerService;
    private final ProductService productService;
    @PostConstruct
    private void create(){
        saveCustomer();
        saveProduct();
    }

    private void saveProduct(){
        Product product1 = Product.builder()
                .name("Sugar")
                .price(120d)
                .isactive(true)
                .brand("A Brand")
                .model("B Model")
                .stock(500)
                .build();
        Product product2 = Product.builder()
                .name("Flour")
                .price(420d)
                .isactive(true)
                .brand("A Brand")
                .model("C Model")
                .stock(100)
                .build();
        Product product3 = Product.builder()
                .name("Milk")
                .price(40d)
                .isactive(true)
                .brand("F Brand")
                .model("H Model")
                .stock(50)
                .build();
        Product product4 = Product.builder()
                .name("Macaroni")
                .price(20d)
                .isactive(true)
                .brand("C Brand")
                .model("S Model")
                .stock(125)
                .build();
        productService.saveAll(Arrays.asList(product1, product2,product3,product4));
    }

    private void saveCustomer(){

        Customer customer1 = Customer.builder()
                .name("Muhammet")
                .surname("KAYA")
                .address("Istanbul")
                .telephone("0532 123 45 67")
                .birthdate(1990)
                .email("muhammed@gmail.com")
                .username("m_kaya9").build();
        Customer customer2 = Customer.builder()
                .name("Kenan")
                .surname("KESKIN")
                .address("Istanbul")
                .telephone("0532 785 45 67")
                .birthdate(1980)
                .email("kanen@gmail.com")
                .username("kenan21").build();
        Customer customer3 = Customer.builder()
                .name("Bahar")
                .surname("TAS")
                .address("Ankara")
                .telephone("0532 785 87 67")
                .birthdate(1984)
                .email("bahar@gmail.com")
                .username("bahar99").build();
        Customer customer4 = Customer.builder()
                .name("Mehmet")
                .surname("KAYA")
                .address("Izmir")
                .telephone("0532 785 45 67")
                .birthdate(1988)
                .email("mehmet@gmail.com")
                .username("kaya23").build();
        Customer customer5 = Customer.builder()
                .name("Ayşe")
                .surname("KAYA")
                .address("Adana")
                .telephone("0532 785 45 98")
                .birthdate(1991)
                .email("ayse@gmail.com")
                .username("ayse54").build();
        customerService.saveAll(Arrays.asList(customer1,customer2,customer3,customer4,customer5));
    }

}


