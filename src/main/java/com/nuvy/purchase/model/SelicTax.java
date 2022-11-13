package com.nuvy.purchase.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SelicTax {

    private String valor;

    public BigDecimal getTax(){
        return new BigDecimal(valor);
    }
}
