package com.example.multiplesource.repository.secondary;

import com.example.multiplesource.model.secondary.SecondaryCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryCustomerRepository extends JpaRepository<SecondaryCustomer, Long> {
}

