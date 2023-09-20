package com.pos.pointOfSale.service;

import com.pos.pointOfSale.dto.ItemDto;
import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;

import java.util.List;

public interface ItemService {

    String addItem(ItemSaveRequestDto itemSaveRequestDto);

    List<ItemDto> getAllItems();
}
