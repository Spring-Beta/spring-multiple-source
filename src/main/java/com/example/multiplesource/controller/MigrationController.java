package com.example.multiplesource.controller;

import com.example.multiplesource.constant.ApplicationConstant;
import com.example.multiplesource.service.DataMigrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApplicationConstant.BASE_PATH)
public class MigrationController {

    private final DataMigrationService migrationService;

    @Autowired
    public MigrationController(DataMigrationService migrationService) {
        this.migrationService = migrationService;
    }

    @GetMapping
    public ResponseEntity<String> migrateData() {
        migrationService.migrateData();
        return ResponseEntity.ok("Data migration completed successfully!");
    }
}

