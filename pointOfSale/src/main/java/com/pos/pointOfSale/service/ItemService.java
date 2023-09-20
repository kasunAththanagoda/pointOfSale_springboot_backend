package com.pos.pointOfSale.service;

import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;

public interface ItemService {

    String addItem(ItemSaveRequestDto itemSaveRequestDto);
}
