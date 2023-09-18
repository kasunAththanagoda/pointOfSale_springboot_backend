package com.pos.pointOfSale.utils.mappers;

import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMappers {
    CustomerDTO entityToDto(Customer customer);
    List<CustomerDTO> entityListToDtoList(List<Customer> customerList);



}
