package com.pos.pointOfSale.service;


import com.pos.pointOfSale.dto.request.CustomerSaveRequestDTO;
import com.pos.pointOfSale.dto.request.CustomerUpdateRequestDTO;


public interface CustomerService {
    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);
}
