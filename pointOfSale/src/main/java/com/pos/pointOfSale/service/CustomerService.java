package com.pos.pointOfSale.service;


import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.dto.request.CustomerSaveRequestDTO;
import com.pos.pointOfSale.dto.request.CustomerUpdateRequestDTO;
import com.pos.pointOfSale.dto.response.ResponseActiveCustomerOnlyNameDto;
import javassist.NotFoundException;

import java.util.List;


public interface CustomerService {
    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws NotFoundException;

    List<CustomerDTO> getCustomerByName(String name) throws NotFoundException;

    List<CustomerDTO> getAllCustomerByActiveStatus() throws NotFoundException;

    List<ResponseActiveCustomerOnlyNameDto> getAllCustomerByActiveStatusOnlyName() throws NotFoundException;
}
