package com.pos.pointOfSale.repository;

import com.pos.pointOfSale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
