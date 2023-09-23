package com.pos.pointOfSale.service;

import com.pos.pointOfSale.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);
}
