package com.example.multiplesource.repository.primary;

import com.example.multiplesource.model.primary.PrimaryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryUserRepository extends JpaRepository<PrimaryUser, Long> {
}

