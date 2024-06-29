package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CabFareDto;
import com.mapping.CabFareMapping;
import com.service.CabFareService;

@RestController
@RequestMapping("/accounting/cab")
public class CabController {

    @Autowired
    CabFareService service;

    @Autowired
    CabFareMapping cabFareMapping;

    @GetMapping(value = "{id}")
    public ResponseEntity<Object> fare(@PathVariable("id") int id) {
        CabFareDto reuslt = service.Get(id);
        return reuslt != null ? ResponseEntity.ok().body(cabFareMapping.ToViewModel(reuslt))
                : ResponseEntity.notFound().build();
    }
}
