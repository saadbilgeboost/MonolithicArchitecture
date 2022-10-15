package com.saad.Java3Monolithic.repository;

import com.saad.Java3Monolithic.repository.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesRepository extends JpaRepository<Sales, Long> {
}
