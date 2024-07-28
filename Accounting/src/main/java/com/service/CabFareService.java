package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dto.CabFareDto;

@Service
public class CabFareService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${cab.service.url}")
    private String cabBaseUrl;

    public CabFareDto Get(int id) {
        try {
            String url = cabBaseUrl + "/cab/fare/" + id;
            return restTemplate.getForObject(url, CabFareDto.class);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }
}
