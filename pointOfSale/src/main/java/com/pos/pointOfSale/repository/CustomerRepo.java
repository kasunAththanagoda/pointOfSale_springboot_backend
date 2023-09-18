package com.pos.pointOfSale.repository;

import com.pos.pointOfSale.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    List<Customer> findAllByCustomerNameEquals(String name);
}
