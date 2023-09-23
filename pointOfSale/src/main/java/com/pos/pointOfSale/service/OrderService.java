package com.pos.pointOfSale.service;

import com.pos.pointOfSale.dto.paginated.PaginatedResponseOrderDetailsDto;
import com.pos.pointOfSale.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponseOrderDetailsDto getAllOrdersFiltred(boolean state, int page, int size);

    PaginatedResponseOrderDetailsDto getAllOrdersFilteredWithoutState(int page, int size);
}
