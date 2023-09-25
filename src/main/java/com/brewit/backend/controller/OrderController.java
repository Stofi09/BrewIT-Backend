package com.brewit.backend.controller;

import com.brewit.backend.model.dto.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order/v1")
@RestController
public class OrderController {

    @PostMapping("/place-order")
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok().body(Map.of("message", "Order received"));
    }
}
