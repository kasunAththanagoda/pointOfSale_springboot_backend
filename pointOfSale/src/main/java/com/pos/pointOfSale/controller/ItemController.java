package com.pos.pointOfSale.controller;

import com.pos.pointOfSale.dto.ItemDto;
import com.pos.pointOfSale.dto.paginated.PaginatedResponseItemDto;
import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.dto.request.ItemUpdateRequestDto;
import com.pos.pointOfSale.service.ItemService;
import com.pos.pointOfSale.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = {"/save"})
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDto itemSaveRequestDto) {
        String id = itemService.addItem(itemSaveRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id + " item saved successfully", id),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "get-all-items")
    public ResponseEntity<StandardResponse> getAllItems() {
        List<ItemDto> itemDtoList = itemService.getAllItems();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", itemDtoList),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "get-all-items-filter-by-state", params = "state")
    public ResponseEntity<StandardResponse> getAllItemsFilterByState(@RequestParam(value = "state") String state) {
        List<ItemDto> itemDtoList;
        if (state.equalsIgnoreCase("active") || state.equalsIgnoreCase("inactive")) {
            boolean status = state.equalsIgnoreCase("active") ? true : false;
            itemDtoList = itemService.getAllFilterByState(status);

        } else {
            itemDtoList = itemService.getAllItems();
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", itemDtoList),
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = {"/delete-item-byme/{id}"})
    public ResponseEntity<StandardResponse> deleteItem(@PathVariable(value = "id") int id) {
        int deletedId = itemService.deleteItem(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "item deleted", deletedId),
                HttpStatus.OK
        );
    }

    @PutMapping(path = {"/update-item-by-query-byme/{id}"})
    public ResponseEntity<StandardResponse> updateItemByQuery(@RequestBody ItemUpdateRequestDto itemUpdateRequestDto, @PathVariable(value = "id") int id) {
        String updated = itemService.updateItemByQuery(id, itemUpdateRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "successflly updated", updated),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/search-item-by-id-byme/{id}")
    public ResponseEntity<StandardResponse> searchItemById(@PathVariable(value = "id") int id) {
        ItemDto itemDto = itemService.searchItemById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "data", itemDto),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "count-items-by-state-byme", params = "state")
    public ResponseEntity<StandardResponse> countByState(@RequestParam(value = "state") String state) {
        int count = itemService.countByState(state);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", count),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "get-all-items-paginated",
            params = {"page","size"}
    )
    public ResponseEntity<StandardResponse> getAllItemsPaginated(
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")@Size(max = 50) int size){
        PaginatedResponseItemDto paginatedResponseItemDto=itemService.getAllItemsPaginated(page,size);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",paginatedResponseItemDto),
                HttpStatus.OK
        );
    }


}
