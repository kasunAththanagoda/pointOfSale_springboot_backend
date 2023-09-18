package com.pos.pointOfSale.service.impl;

import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.dto.request.CustomerSaveRequestDTO;
import com.pos.pointOfSale.dto.request.CustomerUpdateRequestDTO;
import com.pos.pointOfSale.entity.Customer;
import com.pos.pointOfSale.repository.CustomerRepo;
import com.pos.pointOfSale.service.CustomerService;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {

        Customer customer = new Customer(
//                customerSaveRequestDTO.getCustomerId(),
                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getSalary(),
                customerSaveRequestDTO.getContactNumber(),
                customerSaveRequestDTO.getNic(),
                false
        );
        customerRepo.save(customer);
        return customer.getCustomerName() + "saved with :" + customer.getCustomerId() + " id";
    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerId());

            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setSalary(customerUpdateRequestDTO.getSalary());
            customer.setNic(customerUpdateRequestDTO.getNic());
            customer.setContactNumber(customerUpdateRequestDTO.getContactNumber());
            customer.setActiveStatus(customerUpdateRequestDTO.isActiveStatus());

            customerRepo.save(customer);

            return "user updated";

        } else {
            System.out.println("user id not found");
            return "user id not found";
        }
    }

    @Override
    public CustomerDTO getCustomerById(int id) {
        Optional<Customer> customer = customerRepo.findById(id);

        if (customer.isPresent()) {
//            CustomerDTO customerDTO=new CustomerDTO();
            CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class);
            return customerDTO;
        } else {
            return null;
        }


    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomersEntity = customerRepo.findAll();

        List<CustomerDTO> customerDtoList = new ArrayList<>();
//        for(Customer c:allCustomersEntity){
//            CustomerDTO customerDTO=new CustomerDTO(
//              c.getCustomerId(),
//              c.getCustomerName(),
//              c.getCustomerAddress(),
//              c.getSalary(),
//              c.getContactNumber(),
//              c.getNic(),
//              c.isActiveStatus()
//            );
//            customerDtoList.add(customerDTO);
//        }

        List<CustomerDTO> customerDTOS = modelMapper
                .map(allCustomersEntity, new TypeToken<List<CustomerDTO>>() {
                }.getType());

        return customerDTOS;
    }

    @Override
    public boolean deleteCustomer(int id) throws NotFoundException {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
        }
        else{
            throw new NotFoundException("Not found customer for this id");
        }
        return true;
    }

    @Override
    public List<CustomerDTO> getCustomerByName(String name) throws NotFoundException {
        List<Customer> customersList=customerRepo.findAllByCustomerNameEquals(name);
        if(customersList.size()!=0){
            List<CustomerDTO> customerDTOList=modelMapper
                    .map(customersList, new TypeToken<List<CustomerDTO>>() {
                    }.getType());
            return customerDTOList;
        }
        else{
            throw new NotFoundException("no results found");
        }
    }
}
