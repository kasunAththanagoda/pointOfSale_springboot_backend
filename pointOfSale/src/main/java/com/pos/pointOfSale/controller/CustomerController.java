package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.CustomerDTO;
import com.pos.pointOfSale.dto.request.CustomerSaveRequestDTO;
import com.pos.pointOfSale.dto.request.CustomerUpdateRequestDTO;
import com.pos.pointOfSale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping(path = "get-all-customers")
//    public CustomerDTO getAllCustomers(){
//
//    }

}
