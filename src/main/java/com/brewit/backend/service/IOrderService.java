package com.brewit.backend.service;

import com.brewit.backend.model.dto.OrderDTO;

public interface IOrderService {
    void processOrder(OrderDTO orderDTO);
}
