package com.example.multiplesource.repository.target;

import com.example.multiplesource.model.target.TargetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TargetUserRepository extends JpaRepository<TargetUser, Long> {
}

