package com.saad.Java3Monolithic.service;

import com.saad.Java3Monolithic.dto.response.CustomerFindByIdResponseDto;
import com.saad.Java3Monolithic.mapper.CustomerMapper;
import com.saad.Java3Monolithic.repository.ICustomerRepository;
import com.saad.Java3Monolithic.repository.entity.Customer;
import com.saad.Java3Monolithic.utility.ServiceManager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends ServiceManager<Customer, Long> {
    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        customer.setCreatedate(System.currentTimeMillis());
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public List<Customer> findByAddress(String address) {
        return customerRepository.findByAddress(address);
    }

    public Iterable<Customer> saveAll(List<Customer> customers) {
        customers.forEach(customer -> {
            customer.setCreatedate(System.currentTimeMillis());
        });
        return customerRepository.saveAll(customers);
    }


    public CustomerFindByIdResponseDto findByIdDto(Long id) {
        Customer customer = customerRepository.getReferenceById(id);
        return CustomerMapper.INSTANCE.toCustomerFindByIdResponseDto(customer);
    }

    public Boolean isExistCustomer(String username, String password){
        return customerRepository.isExistCustomer(username,password);
    }

}