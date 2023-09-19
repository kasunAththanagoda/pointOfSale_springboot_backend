package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.dto.request.CustomerSaveRequestDTO;
import com.pos.pointOfSale.dto.request.CustomerUpdateQueryRequestDto;
import com.pos.pointOfSale.dto.request.CustomerUpdateRequestDTO;
import com.pos.pointOfSale.dto.response.EndpointTwoResponseDto;
import com.pos.pointOfSale.dto.response.ResponseActiveCustomerOnlyNameDto;
import com.pos.pointOfSale.service.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String addCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO){
        System.out.println("customer :"+customerSaveRequestDTO);
        return customerService.addCustomer(customerSaveRequestDTO);

    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO){
        return customerService.updateCustomer(customerUpdateRequestDTO);
    }

    @GetMapping(path = {"/get-by-id"}, params = {"id"})
    public CustomerDTO getById(@RequestParam(value = "id") int id){
        CustomerDTO customerDTO=customerService.getCustomerById(id);

        return customerDTO;
    }

    @GetMapping(path = {"/get-all-customers"})
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers=customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = {"/delete-customer/{id}"})
    public String deleteCustomer(@PathVariable int id) throws NotFoundException {
        boolean customerDeleted=customerService.deleteCustomer(id);
        if(customerDeleted){
            return "customer deleted";
        }else {
            return "customer deletion failed";
        }
    }

    @GetMapping(path = {"/get-by-name"},params = "name")
    public List<CustomerDTO> getCustomerByName(@RequestParam(value = "name") String name) throws NotFoundException {
        List<CustomerDTO> customerDTOS = customerService.getCustomerByName(name);
        return customerDTOS;
    }

    @GetMapping(path = {"/et-by-activeStatus"})
    public List<CustomerDTO> getCustomersByActiveStatus() throws NotFoundException {
        List<CustomerDTO> customerDTOList=customerService.getAllCustomerByActiveStatus();
        return customerDTOList;
    }

    @GetMapping(path = {"/get-by-activeStatus-onlyName"})
    public List<ResponseActiveCustomerOnlyNameDto> getCustomersByActiveStatusOnlyName() throws NotFoundException {
        List<ResponseActiveCustomerOnlyNameDto> responseActiveCustomerOnlyNameDtos =customerService.getAllCustomerByActiveStatusOnlyName();
        return responseActiveCustomerOnlyNameDtos;
    }

    @PutMapping(path = {"/update-by-query/{id}"})
    public String updateCustomerByQuery(@PathVariable(value = "id")int id, @RequestBody CustomerUpdateQueryRequestDto customerUpdateQueryRequestDto){
        return customerService.updateCustomerByQuery(id,customerUpdateQueryRequestDto);
    }

    @GetMapping(path = {"/endpoint2/{id}"})
    public EndpointTwoResponseDto endpointTwo(@PathVariable(value = "id")int id){
        return customerService.endpointTwo(id);
    }

    @GetMapping(path={"/get-by-nic"},params = {"nic"})
    public CustomerDTO getCustomerByNic(@RequestParam(value = "nic")String nic) {
        return customerService.getCustomerByNic(nic);
    }

}
