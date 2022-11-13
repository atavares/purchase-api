package com.nuvy.purchase.api.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class PaymentRequest {

    private BigDecimal entry;
    private Integer installments;

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "entry=" + entry +
                ", installments=" + installments +
                '}';
    }
}
