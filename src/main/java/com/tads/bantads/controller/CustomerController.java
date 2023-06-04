package com.tads.bantads.controller;

import com.tads.bantads.dto.CustomerDTO;
import com.tads.bantads.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<EntityModel<CustomerDTO>> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO createdCustomer = customerService.createCustomer(customerDTO);

        EntityModel<CustomerDTO> customerResource = EntityModel.of(createdCustomer);
        customerResource.add(linkTo(methodOn(CustomerController.class).getCustomer(createdCustomer.id())).withSelfRel());

        return ResponseEntity.created(URI.create(customerResource.getRequiredLink(IanaLinkRelations.SELF).getHref())).body(customerResource);
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
