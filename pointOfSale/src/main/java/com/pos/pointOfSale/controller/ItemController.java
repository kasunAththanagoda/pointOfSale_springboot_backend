package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.ItemDto;
import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.service.ItemService;
import com.pos.pointOfSale.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping(path = "get-all-items")
    public ResponseEntity<StandardResponse> getAllItems(){
        List<ItemDto> itemDtoList =itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",itemDtoList),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-items-filter0by-state",params = "state")
    public ResponseEntity<StandardResponse> getAllItemsFilterByState(@RequestParam(value = "state")String state){
        List<ItemDto> itemDtoList;
        if(state.equalsIgnoreCase("active") || state.equalsIgnoreCase("inactive")){
            boolean status=state.equalsIgnoreCase("active")? true : false;
            itemDtoList =itemService.getAllFilterByState(status);

        }
        else{
            itemDtoList =itemService.getAllItems();
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",itemDtoList),
                HttpStatus.OK
        );
    }

}
