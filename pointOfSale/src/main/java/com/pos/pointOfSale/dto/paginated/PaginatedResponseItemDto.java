package com.pos.pointOfSale.dto.paginated;

import com.pos.pointOfSale.dto.ItemDto;

import java.util.List;

public class PaginatedResponseItemDto {
    private List<ItemDto> itemDtoList;
    private Long dataCount;

    @Override
    public String toString() {
        return "PaginatedResponseItemDto{" +
                "itemDtoList=" + itemDtoList +
                ", dataCount=" + dataCount +
                '}';
    }

    public List<ItemDto> getItemDtoList() {
        return itemDtoList;
    }

    public void setItemDtoList(List<ItemDto> itemDtoList) {
        this.itemDtoList = itemDtoList;
    }

    public Long getDataCount() {
        return dataCount;
    }

    public void setDataCount(Long dataCount) {
        this.dataCount = dataCount;
    }

    public PaginatedResponseItemDto(List<ItemDto> itemDtoList, Long dataCount) {
        this.itemDtoList = itemDtoList;
        this.dataCount = dataCount;
    }

    public PaginatedResponseItemDto() {
    }
}
