package com.pos.pointOfSale.service.impl;

import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.entity.Item;
import com.pos.pointOfSale.repository.ItemRepo;
import com.pos.pointOfSale.service.ItemService;
import com.pos.pointOfSale.utils.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String addItem(ItemSaveRequestDto itemSaveRequestDto) {
        Item item=itemMapper.requestDtoToEntity(itemSaveRequestDto);
        item.setActiveState(true);
        return itemRepo.save(item).getItemName()+" saved";
    }
}
