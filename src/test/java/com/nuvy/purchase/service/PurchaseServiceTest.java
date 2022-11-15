package com.nuvy.purchase.service;

import com.nuvy.purchase.api.request.PaymentRequest;
import com.nuvy.purchase.api.request.ProductRequest;
import com.nuvy.purchase.api.request.PurchaseRequest;
import com.nuvy.purchase.api.response.PurchaseResponse;
import com.nuvy.purchase.model.SelicTax;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PurchaseServiceTest {

    @Mock
    private SelicService selicService;

    @InjectMocks
    private PurchaseService purchaseService;

    @Test
    void mustBuyProductWithoutFees() {

        ProductRequest por = new ProductRequest(123L, "Pacote de dados", new BigDecimal("30"));
        PaymentRequest par = new PaymentRequest(new BigDecimal("30"), 2);
        PurchaseRequest purchaseRequest = new PurchaseRequest(por, par);

        PurchaseResponse response = purchaseService.buyProduct(purchaseRequest);

        assertEquals(response.getInstallments().get(0).getTax(), BigDecimal.ZERO);
        assertEquals(response.getInstallments().size(), 2);
    }

    @Test
    void mustBuyProductWithFees() {

        ProductRequest por = new ProductRequest(123L, "Pacote de dados", new BigDecimal("300"));
        PaymentRequest par = new PaymentRequest(new BigDecimal("300"), 10);
        PurchaseRequest purchaseRequest = new PurchaseRequest(por, par);
        SelicTax selicTax = new SelicTax();
        selicTax.setValor("1.0");

        when(selicService.searchSelicTax()).thenReturn(selicTax);

        PurchaseResponse response = purchaseService.buyProduct(purchaseRequest);

        assertNotEquals(response.getInstallments().get(0).getTax(), BigDecimal.ZERO);
        assertEquals(response.getInstallments().size(), 10);
    }
}
