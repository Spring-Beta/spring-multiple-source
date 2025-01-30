package com.example.multiplesource.service.secondary.impl;

import com.example.multiplesource.model.secondary.SecondaryCustomer;
import com.example.multiplesource.repository.secondary.SecondaryCustomerRepository;
import com.example.multiplesource.service.secondary.ISecondaryCustomerService;
import org.springframework.stereotype.Service;

@Service
public class SecondaryCustomerServiceService implements ISecondaryCustomerService {
    private final SecondaryCustomerRepository secondaryCustomerRepository;

    public SecondaryCustomerServiceService(SecondaryCustomerRepository secondaryCustomerRepository) {
        this.secondaryCustomerRepository = secondaryCustomerRepository;
    }

    @Override
    public SecondaryCustomer save(SecondaryCustomer secondaryCustomer) {
        return secondaryCustomerRepository.save(secondaryCustomer);
    }
}
