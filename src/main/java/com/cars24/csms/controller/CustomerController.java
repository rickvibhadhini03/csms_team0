package com.cars24.csms.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping("/profile")
    public String getCustomer(){
        return "Welcome to my SPRING WEBSITE";
    }
//    @PostMapping
//    @PutMapping
//    @DeleteMapping
}