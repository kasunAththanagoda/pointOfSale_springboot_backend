package com.pos.pointOfSale.service.impl;

import com.pos.pointOfSale.dto.ItemDto;
import com.pos.pointOfSale.dto.paginated.PaginatedResponseItemDto;
import com.pos.pointOfSale.dto.request.ItemSaveRequestDto;
import com.pos.pointOfSale.dto.request.ItemUpdateRequestDto;
import com.pos.pointOfSale.entity.Item;
import com.pos.pointOfSale.entity.enums.MeasuringUnits;
import com.pos.pointOfSale.exception.NotFoundException;
import com.pos.pointOfSale.repository.ItemRepo;
import com.pos.pointOfSale.service.ItemService;
import com.pos.pointOfSale.utils.mappers.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String addItem(ItemSaveRequestDto itemSaveRequestDto) {
        Item item = itemMapper.requestDtoToEntity(itemSaveRequestDto);
        item.setActiveState(true);
        return itemRepo.save(item).getItemName() + " saved";
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> all = itemRepo.findAll();
        List<ItemDto> itemDtoList = itemMapper.entityListToDtoList(all);
        return itemDtoList;
    }

    @Override
    public List<ItemDto> getAllFilterByState(boolean status) {
        List<Item> itemList = itemRepo.findByActiveStateEquals(status);
        List<ItemDto> itemDtoList = itemMapper.entityListToDtoList(itemList);
        return itemDtoList;
    }

    @Override
    public int deleteItem(int id) {
        if (itemRepo.existsById(id)) {
            itemRepo.deleteById(id);
            return id;
        } else {
            throw new NotFoundException("id not found");
        }
    }

    @Override
    public String updateItemByQuery(int id, ItemUpdateRequestDto itemUpdateRequestDto) {
        if (itemRepo.existsById(id)) {
//            Item item=itemMapper.updateRequestDtoToItemEntity(itemUpdateRequestDto);
//            item.setItemId(id);
            itemRepo.updateItemByQuery(itemUpdateRequestDto.getItemName(), itemUpdateRequestDto.getMeasuringUnit(), itemUpdateRequestDto.getBalanceQty(), itemUpdateRequestDto.getSupplierPrice(), itemUpdateRequestDto.getSellingPrice(), id);
            return "item updated";
        } else {
            throw new NotFoundException("id not found");
        }
    }

    @Override
    public ItemDto searchItemById(int id) {
        Optional<Item> byId = itemRepo.findById(id);
        if (byId.isPresent()) {
            ItemDto itemDto = itemMapper.entityToDto(byId.get());
            return itemDto;
        } else {
            throw new NotFoundException("id not found");
        }


    }

    @Override
    public int countByState(String state) {
        boolean status = state.equalsIgnoreCase("active") ? true : false;
        long count = itemRepo.countAllByActiveStateEquals(status);
        return (int) count;
    }

    @Override
    public PaginatedResponseItemDto getAllItemsPaginated(int page, int size) {
        Page<Item> itemsPaginated=itemRepo.findAll(PageRequest.of(page, size));
        return new PaginatedResponseItemDto(
                itemMapper.pageToList(itemsPaginated),
                itemRepo.count()
        );
    }

    @Override
    public PaginatedResponseItemDto getAllItemsPaginatedFilterByActiveStatus(int page, int size, boolean activeStatus) {
        Page<Item> items=itemRepo.findAllByActiveStateEquals(activeStatus,PageRequest.of(page, size));
        PaginatedResponseItemDto paginatedResponseItemDto=new PaginatedResponseItemDto(
                itemMapper.pageToList(items),
                itemRepo.countAllByActiveStateEquals(activeStatus)
        );
        return paginatedResponseItemDto;
    }


}
