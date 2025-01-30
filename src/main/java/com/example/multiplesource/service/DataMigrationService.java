package com.example.multiplesource.service;

import com.example.multiplesource.model.primary.PrimaryUser;
import com.example.multiplesource.model.secondary.SecondaryCustomer;
import com.example.multiplesource.model.target.TargetUser;
import com.example.multiplesource.repository.primary.PrimaryUserRepository;
import com.example.multiplesource.repository.secondary.SecondaryCustomerRepository;
import com.example.multiplesource.repository.target.TargetUserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DataMigrationService {

    private final PrimaryUserRepository primaryUserRepository;
    private final SecondaryCustomerRepository secondaryCustomerRepository;
    private final TargetUserRepository targetUserRepository;

    @Autowired
    public DataMigrationService(PrimaryUserRepository primaryUserRepository,
                                SecondaryCustomerRepository secondaryCustomerRepository,
                                TargetUserRepository targetUserRepository) {
        this.primaryUserRepository = primaryUserRepository;
        this.secondaryCustomerRepository = secondaryCustomerRepository;
        this.targetUserRepository = targetUserRepository;
    }

    @Transactional
    public void migrateData() {
        log.info("🚀 Starting Data Migration...");

        List<PrimaryUser> users = primaryUserRepository.findAll();
        log.info("✅ Fetched {} users from Primary Database", users.size());

        List<SecondaryCustomer> customers = secondaryCustomerRepository.findAll();
        log.info("✅ Fetched {} customers from Secondary Database", customers.size());

        for (int i = 0; i < Math.min(users.size(), customers.size()); i++) {
            PrimaryUser user = users.get(i);
            SecondaryCustomer customer = customers.get(i);

            TargetUser targetUser = new TargetUser();
            targetUser.setName(user.getName());
            targetUser.setEmail(user.getEmail());
            targetUser.setFullName(customer.getFullName());
            targetUser.setContact(customer.getContact());

            targetUserRepository.save(targetUser);
            log.info("✅ Migrated user {} -> {}", user.getName(), customer.getFullName());
        }
        log.info("✅ Data Migration Completed Successfully!");
    }
}
