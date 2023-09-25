package com.brewit.backend.model.dto;

import java.math.BigDecimal;

public class OrderItemDTO {
    private Long beerId;
    private String beerName;
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

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "beerId=" + beerId +
                ", beerName='" + beerName + '\'' +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
