package com.nuvy.purchase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Installments {
    private Integer installmentsNum;
    private BigDecimal price;
    private BigDecimal tax;

}
