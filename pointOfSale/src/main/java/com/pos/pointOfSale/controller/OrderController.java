package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.dto.request.RequestOrderSaveDto;
import com.pos.pointOfSale.service.OrderService;
import com.pos.pointOfSale.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

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

    @GetMapping(path = "/get-order-filtered",params = {"stateType","page","size"})
    public ResponseEntity<StandardResponse> getOrdersFiltered(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size")@Max(50) int size
    ){
        PaginatedResponseOrderDetailsDto paginatedResponseOrderDetailsDto=null;

        if(stateType.equalsIgnoreCase("active") || stateType.equalsIgnoreCase("inactive")){
            boolean state=stateType.equalsIgnoreCase("active")? true: false;
            paginatedResponseOrderDetailsDto=orderService.getAllOrdersFiltred(state,page,size);
        }
        else{
            paginatedResponseOrderDetailsDto=orderService.getAllOrdersFilteredWithoutState(page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",paginatedResponseOrderDetailsDto),
                HttpStatus.OK
        );

    }
}
