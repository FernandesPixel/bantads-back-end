package com.tads.bantads.service;

import com.tads.bantads.dto.CustomerDTO;
import com.tads.bantads.mapper.CustomerMapper;
import com.tads.bantads.model.Customer;
import com.tads.bantads.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private AddressService addressService;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.DTOToCustomer(customerDTO);
        addressService.createAddress(customer.getAddress());
        return customerMapper.customerToDTO(clientRepository.saveAndFlush(customer));
    }
}
