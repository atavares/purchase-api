package com.nuvy.purchase.api.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PurchaseRequest {

    @JsonProperty("product")
    private ProductRequest productRequest;

    @JsonProperty("payment")
    private PaymentRequest paymentRequest;

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                "productRequest=" + productRequest +
                ", paymentRequest=" + paymentRequest +
                '}';
    }
}
