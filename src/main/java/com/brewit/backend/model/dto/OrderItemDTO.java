package com.brewit.backend.model.dto;

import java.math.BigDecimal;

public class OrderItemDTO {
    private Long beerId;
    private Integer count;
    private BigDecimal totalPrice;

    // Getters and Setters

    public Long getBeerId() {
        return beerId;
    }

    public void setBeerId(Long beerId) {
        this.beerId = beerId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
