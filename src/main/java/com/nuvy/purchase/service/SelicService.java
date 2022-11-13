package com.nuvy.purchase.service;

import com.nuvy.purchase.model.SelicTax;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class SelicService {
    @Autowired
    private RestTemplate restTemplate;

    public SelicTax searchSelicTax() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String selicResourceUrl = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.11/dados?formato=json&dataInicial="+today+"&dataFinal="+today+"";

        log.info("Init search selic tax {}", selicResourceUrl);
        ResponseEntity<SelicTax[]> response = restTemplate.getForEntity(selicResourceUrl, SelicTax[].class);
        log.info("Finished search selic tax ");
        return response.getBody()[0];
    }

}
