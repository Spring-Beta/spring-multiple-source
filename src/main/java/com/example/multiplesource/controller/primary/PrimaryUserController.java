package com.example.multiplesource.controller.primary;

import com.example.multiplesource.constant.ApplicationConstant;
import com.example.multiplesource.model.primary.PrimaryUser;
import com.example.multiplesource.service.primary.IPrimaryUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApplicationConstant.PRIMARY_BASE_PATH)
public class PrimaryUserController {
    private final IPrimaryUserService primaryUserService;

    public PrimaryUserController(IPrimaryUserService primaryUserService) {
        this.primaryUserService = primaryUserService;
    }

    @PostMapping(ApplicationConstant.SAVE)
    public ResponseEntity<PrimaryUser> save(@RequestBody PrimaryUser primaryUser){
        return ResponseEntity.ok(primaryUserService.save(primaryUser));
    }
}
