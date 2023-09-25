package com.brewit.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order/v1")
@RestController
public class OrderController {

    @GetMapping("/get-order")
    public String getOrder(){
        return "sikerult";
    }
}
