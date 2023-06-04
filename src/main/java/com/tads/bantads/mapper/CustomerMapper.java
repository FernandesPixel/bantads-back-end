package com.tads.bantads.mapper;

import com.tads.bantads.dto.CustomerDTO;
import com.tads.bantads.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    private AddressMapper addressMapper;

    public CustomerDTO customerToDTO(Customer customer) {
        return new CustomerDTO(customer.getName(), customer.getEmail(), customer.getCpf(), addressMapper.addressToDTO(customer.getAddress()));
    }

    public Customer DTOToCustomer(CustomerDTO customerDTO) {
        return Customer.builder()
                .name(customerDTO.name())
                .email(customerDTO.email())
                .cpf(customerDTO.cpf())
                .address(addressMapper.DTOToAddress(customerDTO.address()))
                .build();
    }
}
