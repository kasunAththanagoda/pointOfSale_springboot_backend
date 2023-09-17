package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping("/save")
    public void addCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println("customer :"+customerDTO);


    }
}
