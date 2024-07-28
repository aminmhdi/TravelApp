package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.viewmodel.FareViewModel;

@Service
public class FareService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${accounting.service.url}")
    private String accountingBaseUrl;

    public FareViewModel GetByCabId(int id) {
        try {
            String serviceUrl = accountingBaseUrl + "/accounting/cab/" + id;
            FareViewModel response = restTemplate.getForObject(serviceUrl, FareViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
