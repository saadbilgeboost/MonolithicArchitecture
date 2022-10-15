package com.saad.Java3Monolithic.service;

import com.saad.Java3Monolithic.repository.ISalesRepository;
import com.saad.Java3Monolithic.repository.entity.Sales;
import com.saad.Java3Monolithic.utility.ServiceManager;
import org.springframework.stereotype.Service;


@Service
public class SalesService extends ServiceManager<Sales,Long> {
    private final ISalesRepository salesRepository;

    public SalesService(ISalesRepository salesRepository) {
        super(salesRepository);
        this.salesRepository = salesRepository;
    }
}
