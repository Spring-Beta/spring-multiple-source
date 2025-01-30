package com.example.multiplesource.service.primary.impl;

import com.example.multiplesource.model.primary.PrimaryUser;
import com.example.multiplesource.repository.primary.PrimaryUserRepository;
import com.example.multiplesource.service.primary.IPrimaryUserService;
import org.springframework.stereotype.Service;

@Service
public class PrimaryUserService implements IPrimaryUserService {
    private final PrimaryUserRepository primaryUserRepository;

    public PrimaryUserService(PrimaryUserRepository primaryUserRepository) {
        this.primaryUserRepository = primaryUserRepository;
    }


    @Override
    public PrimaryUser save(PrimaryUser primaryUser) {
        return primaryUserRepository.save(primaryUser);
    }
}
