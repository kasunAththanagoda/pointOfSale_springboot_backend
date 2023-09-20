package com.pos.pointOfSale.utils.mappers;

import com.pos.pointOfSale.dto.ItemDto;
import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDtoToEntity(ItemSaveRequestDto itemSaveRequestDto);


    List<ItemDto> entityListToDtoList(List<Item> itemList);
}
