package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewmodel.BookRequestViewModel;
import com.viewmodel.BookResponseViewModel;
import com.viewmodel.BookViewModel;

@Service
public class BookService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${book.service.url}")
    private String bookBaseUrl;

    public BookResponseViewModel Book(BookRequestViewModel model) {
        try {
            String serviceUrl = bookBaseUrl + "/book";
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(serviceUrl, model, String.class);
            if (responseEntity.getStatusCode() != HttpStatusCode.valueOf(200))
                return null;
            String rawJson = responseEntity.getBody();
            BookResponseViewModel response = new ObjectMapper().readValue(rawJson, BookResponseViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public BookViewModel Get(int id) {
        try {
            String serviceUrl = bookBaseUrl + "/book/" + id;
            BookViewModel response = restTemplate.getForObject(serviceUrl, BookViewModel.class);
            return response;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    public void EndTrip(int id) {
        try {
            String serviceUrl = bookBaseUrl + "/book/" + id;
            restTemplate.put(serviceUrl, String.class);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
