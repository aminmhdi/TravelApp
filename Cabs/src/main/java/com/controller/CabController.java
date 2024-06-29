package com.controller;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CabFareDto;
import com.dto.CabPagedListRequestDto;
import com.entity.Cab;
import com.mapping.CabFareMapping;
import com.mapping.CabMapping;
import com.service.CabService;
import com.viewmodel.*;

@RestController
@RequestMapping("/cab")
public class CabController {
    @Autowired
    CabMapping cabMapping;
    @Autowired
    CabFareMapping cabFareMapping;
    @Autowired
    CabService service;

    @GetMapping(value = "")
    public CabPagedListViewModel list(@ModelAttribute CabPagedListRequestDto model) {
        return cabMapping.ToPagedListViewModel(service.List(model));
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody CabRequestViewModel model) {
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

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody CabUpdateRequestViewModel model) {
        if (model == null)
            return ResponseEntity.badRequest().body("Your request is null or empty");
        if (model.getId() == null || model.getId() == 0)
            return ResponseEntity.badRequest().body("Id is required");
        if (model.getIsAvailable() == null)
            return ResponseEntity.badRequest().body("IsAvailable is required");
        Pair<Boolean, String> result = service.Update(model.getId(), model.getIsAvailable());
        return result.getValue0() ? ResponseEntity.ok().body(result.getValue1())
                : ResponseEntity.badRequest().body(result.getValue1());
    }

    @GetMapping(value = "isAvailable/{id}")
    public ResponseEntity<Boolean> isAvailable(@PathVariable("id") int id) {
        boolean result = service.IsAvailable(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "fare/{id}")
    public ResponseEntity<CabFareViewModel> fare(@PathVariable("id") int id) {
        CabFareDto result = service.GetFare(id);
        return result != null
                ? ResponseEntity.ok().body(cabFareMapping.ToViewModel(result))
                : ResponseEntity.notFound().build();
    }
}
