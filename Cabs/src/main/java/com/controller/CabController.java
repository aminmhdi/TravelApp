package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CabPagedListRequestDto;
import com.entity.Cab;
import com.mapping.CabMapping;
import com.service.CabService;
import com.viewmodel.*;

@RestController
@RequestMapping("/Cab")
public class CabController {

    @Autowired
    CabService service;

    @Autowired
    CabMapping cabMapping;

    @GetMapping(value = "")
    public CabPagedListViewModel list(@ModelAttribute CabPagedListRequestDto model) {
        return cabMapping.ToPagedListViewModel(service.List(model));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> bookCab(@RequestBody CabRequestViewModel model) {
        if (model == null)
            return ResponseEntity.badRequest().body("Your request is null or empty");
        if (model.getDriverName() == null || model.getDriverName().isBlank())
            return ResponseEntity.badRequest().body("Driver name is required");
        if (model.getFrom() == null || model.getFrom().isBlank())
            return ResponseEntity.badRequest().body("From is required");
        if (model.getTo() == null || model.getTo().isBlank())
            return ResponseEntity.badRequest().body("To is required");
        if (model.getType() == 0)
            return ResponseEntity.badRequest().body("Type is required");
        if (model.getAmount() <= 0)
            return ResponseEntity.badRequest().body("Amount is required");
        Cab result = service.Create(cabMapping.ToDataModel(model));
        return ResponseEntity.ok().body(cabMapping.ToViewModel(result));
    }
}
