package com.brewit.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/order/v1")
@RestController
public class OrderController {

    @PostMapping("/place-order")
    public ResponseEntity<String> placeOrder(@RequestBody Map<String, String> payload){
        String message = payload.get("message");
        System.out.println("Received message from the client: " + message);
        return ResponseEntity.ok("Order received with this message: " + message);
    }
}
