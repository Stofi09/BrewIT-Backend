package com.brewit.backend.controller;

import com.brewit.backend.model.dto.OrderDTO;
import com.brewit.backend.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order/v1")
@RestController
public class OrderController {

    private IOrderService orderService;

    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }
    @PostMapping("/place-order")
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody OrderDTO orderDTO) {
        this.orderService.processOrder(orderDTO);
        return ResponseEntity.ok().body(Map.of("message", "Order received"));
    }
}
