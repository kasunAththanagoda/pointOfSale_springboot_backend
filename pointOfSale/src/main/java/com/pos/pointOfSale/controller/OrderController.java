package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.dto.request.RequestOrderSaveDto;
import com.pos.pointOfSale.service.OrderService;
import com.pos.pointOfSale.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {
        System.out.println("data : "+requestOrderSaveDto);
        String id = orderService.addOrder(requestOrderSaveDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", id),
                HttpStatus.CREATED
        );
    }
}
