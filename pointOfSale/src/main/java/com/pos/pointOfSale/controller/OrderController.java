package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.dto.request.RequestOrderSaveDto;
import com.pos.pointOfSale.utils.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/order")
public class OrderController {


    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {
//        String id = itemService.addItem(itemSaveRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "success", 1),
                HttpStatus.CREATED
        );
    }
}
