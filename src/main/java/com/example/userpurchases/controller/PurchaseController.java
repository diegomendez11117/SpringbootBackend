package com.example.userpurchases.controller;

import com.example.userpurchases.model.Purchase;
import com.example.userpurchases.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller that helps to get the information of the Purchase repository.
 */
@RestController
@RequestMapping("api/")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping("purchases")
    public List<Purchase> getPurchases(){
        return purchaseRepository.findAll();
    }
}
