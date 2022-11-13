package com.nuvy.purchase.service;

import com.nuvy.purchase.api.request.PurchaseRequest;
import com.nuvy.purchase.api.response.InstallmentsResponse;
import com.nuvy.purchase.api.response.PurchaseResponse;
import com.nuvy.purchase.model.Installments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {

    @Autowired
    private SelicService selicService;

    public PurchaseResponse buyProduct(PurchaseRequest purchaseRequest){
        return new PurchaseResponse(generateInstallments(purchaseRequest.getProductRequest().getPrice(),
                                    purchaseRequest.getPaymentRequest().getInstallments())
                                                        .stream()
                                                        .map(InstallmentsResponse::new)
                                                        .collect(Collectors.toList()));
    }

    private List<Installments> generateInstallments(BigDecimal totalPrice,
                                                    Integer installments) {

        BigDecimal price = totalPrice.divide(new BigDecimal(installments), RoundingMode.HALF_UP);
        BigDecimal tax = calcTax(installments);

        List<Installments> installmentsList = new ArrayList<>();

        for (int i = 1; i<= installments; i++) {
            installmentsList.add(new Installments(i, price, tax));
        }

        return installmentsList;
    }

    private BigDecimal calcTax(Integer installments) {

        if(installments > 6){
            return selicService.searchSelicTax().getTax();
        } else{
            return BigDecimal.ZERO;
        }
    }

}
