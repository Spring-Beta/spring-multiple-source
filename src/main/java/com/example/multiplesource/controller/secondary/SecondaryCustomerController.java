package com.example.multiplesource.controller.secondary;

import com.example.multiplesource.constant.ApplicationConstant;
import com.example.multiplesource.model.secondary.SecondaryCustomer;
import com.example.multiplesource.service.secondary.ISecondaryCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApplicationConstant.SECONDARY_BASE_PATH)
public class SecondaryCustomerController {
    private final ISecondaryCustomerService secondaryCustomerService;

    public SecondaryCustomerController(ISecondaryCustomerService secondaryCustomerService) {
        this.secondaryCustomerService = secondaryCustomerService;
    }

    @PostMapping(ApplicationConstant.SAVE)
    public ResponseEntity<SecondaryCustomer> save(@RequestBody SecondaryCustomer secondaryCustomer) {
        return ResponseEntity.ok(secondaryCustomerService.save(secondaryCustomer));
    }
}
