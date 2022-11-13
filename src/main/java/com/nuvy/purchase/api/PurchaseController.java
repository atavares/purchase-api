package com.nuvy.purchase.api;

import com.nuvy.purchase.api.request.PurchaseRequest;
import com.nuvy.purchase.api.response.PurchaseResponse;
import com.nuvy.purchase.service.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/product")
    public ResponseEntity<PurchaseResponse> buyProduct(@RequestBody PurchaseRequest purchaseRequest){
        log.info("Init buy product {}", purchaseRequest);
        PurchaseResponse purchaseResponse = purchaseService.buyProduct(purchaseRequest);
        log.info("Finished buy product {}", purchaseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseResponse);
    }
}
