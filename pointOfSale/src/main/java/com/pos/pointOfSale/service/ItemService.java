package com.pos.pointOfSale.service;

import com.pos.pointOfSale.dto.ItemDto;
import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.dto.request.ItemUpdateRequestDto;

import java.util.List;

public interface ItemService {

    String addItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemDto> getAllItems();

    List<ItemDto> getAllFilterByState(boolean status);

    int deleteItem(int id);

    String updateItemByQuery(int id, ItemUpdateRequestDto itemUpdateRequestDto);

    ItemDto searchItemById(int id);

    int countByState(String state);
}
