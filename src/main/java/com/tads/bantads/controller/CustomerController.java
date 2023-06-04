package com.tads.bantads.controller;

import com.tads.bantads.dto.CustomerDTO;
import com.tads.bantads.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok().body(customerService.createCustomer(customerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID id){
        Optional<CustomerDTO> customer = customerService.getCustomer(id);
        if(customer.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(customer.get());
    }
}
