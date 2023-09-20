package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.service.ItemService;
import com.pos.pointOfSale.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto){
        String id=itemService.addItem(itemSaveRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+" item saved successfully",id),
                HttpStatus.CREATED
        );
    }

}
