package com.brewit.backend.model.dto;

import java.util.List;

public class OrderDTO {
    private Long userId;
    private List<OrderItemDTO> items;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "userId=" + userId +
                ", items=" + items +
                '}';
    }
}
