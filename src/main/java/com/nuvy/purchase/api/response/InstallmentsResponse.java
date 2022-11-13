package com.nuvy.purchase.api.response;

import com.nuvy.purchase.model.Installments;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class InstallmentsResponse {

    private Integer installmentsNum;
    private BigDecimal price;
    private BigDecimal tax;

    public InstallmentsResponse(Installments installments) {
        this.installmentsNum = installments.getInstallmentsNum();
        this.price = installments.getPrice();
        this.tax = installments.getTax();
    }
}
