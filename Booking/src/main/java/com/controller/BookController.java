package com.controller;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.BookCab;
import com.service.BookService;
import com.mapping.*;
import com.viewmodel.*;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService service;

	@Autowired
	BookMapping bookCabMapping;

	@PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> bookCab(@RequestBody BookRequestViewModel model) {
		if (model == null || model.getCabId() == null || model.getEmail() == null)
			return ResponseEntity.badRequest().body("Your cab id or email is not valid");
		BookCab result = service.Create(bookCabMapping.ToDataModel(model));
		return result != null ? ResponseEntity.ok().body(bookCabMapping.ToViewModel(result))
				: ResponseEntity.badRequest().body("Cab is not available now!");
	}

	@PutMapping(value = "/{bookId}")
	public ResponseEntity<String> endTrip(@PathVariable("bookId") int bookId) {
		Pair<Boolean, String> result = service.Update(bookId);
		return result.getValue0() ? ResponseEntity.ok().body(result.getValue1())
				: ResponseEntity.badRequest().body(result.getValue1());
	}
}