package com.nuvy.purchase.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PurchaseResponse {

    private List<InstallmentsResponse> installments;
}
