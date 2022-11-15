package com.nuvy.purchase.api;

import com.nuvy.purchase.api.request.PurchaseRequest;
import com.nuvy.purchase.api.response.PurchaseResponse;
import com.nuvy.purchase.service.PurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Purchase Product API", description = "Purchase new product", tags = {"Purchase Product"})
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(hidden = true))),
                   @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true)))})
    @PostMapping("/product")
    public ResponseEntity<PurchaseResponse> buyProduct(@RequestBody PurchaseRequest purchaseRequest){
        log.info("Init buy product {}", purchaseRequest);
        PurchaseResponse purchaseResponse = purchaseService.buyProduct(purchaseRequest);
        log.info("Finished buy product {}", purchaseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseResponse);
    }
}
