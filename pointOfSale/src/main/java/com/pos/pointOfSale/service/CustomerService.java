package com.pos.pointOfSale.service;


import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.dto.request.CustomerSaveRequestDTO;
import com.pos.pointOfSale.dto.request.CustomerUpdateRequestDTO;

import java.util.List;


public interface CustomerService {
    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();
}
