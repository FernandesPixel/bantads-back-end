package com.tads.bantads.service;

import com.tads.bantads.dto.CustomerDTO;
import com.tads.bantads.mapper.CustomerMapper;
import com.tads.bantads.model.Customer;
import com.tads.bantads.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private AddressService addressService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.DTOToCustomer(customerDTO);
        addressService.createAddress(customer.getAddress());
        return customerMapper.customerToDTO(customerRepository.saveAndFlush(customer));
    }

    public Optional<CustomerDTO> getCustomer(UUID id) {
        return customerRepository.findById(id)
                .stream()
                .findFirst()
                .map(customerMapper::customerToDTO);
    }
}
