package com.pos.pointOfSale.utils.mappers;

import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDtoToEntity(ItemSaveRequestDto itemSaveRequestDto);
}
