package com.pos.pointOfSale.service.impl;

import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.dto.request.CustomerSaveRequestDTO;
import com.pos.pointOfSale.dto.request.CustomerUpdateRequestDTO;
import com.pos.pointOfSale.entity.Customer;
import com.pos.pointOfSale.repository.CustomerRepo;
import com.pos.pointOfSale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {

        Customer customer=new Customer(
//                customerSaveRequestDTO.getCustomerId(),
                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getSalary(),
                customerSaveRequestDTO.getContactNumber(),
                customerSaveRequestDTO.getNic(),
                false
        );
        customerRepo.save(customer);
        return customer.getCustomerName() +"saved with :"+customer.getCustomerId()+" id";
    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if(customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())){
            Customer customer= customerRepo.getById(customerUpdateRequestDTO.getCustomerId());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setSalary(customerUpdateRequestDTO.getSalary());
            customer.setNic(customerUpdateRequestDTO.getNic());
            customer.setContactNumber(customerUpdateRequestDTO.getContactNumber());
            customer.setActiveStatus(customerUpdateRequestDTO.isActiveStatus());

            customerRepo.save(customer);

            return "user updated";

        }else{
            System.out.println("user id not found");
            return "user id not found";
        }
    }
}
