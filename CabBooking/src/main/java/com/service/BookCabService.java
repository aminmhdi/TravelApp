package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BookCab;
import com.repository.BookCabRepository;

@Service
public class BookCabService {
	@Autowired
	BookCabRepository bookCabRepository;

	public String CreateBookCab(BookCab model) {
		Optional<BookCab> result = bookCabRepository.findById(model.getBcid());
		if (result.isPresent()) {
			return "Book cab already exists";
		} else {
			bookCabRepository.save(model);
			return "Cab is booked";
		}
	}
	
	
}
