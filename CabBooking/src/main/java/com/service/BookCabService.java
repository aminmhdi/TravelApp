package com.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.BookCab;
import com.repository.BookCabRepository;

@Service
public class BookCabService {
	@Autowired
	BookCabRepository bookCabRepository;

	public BookCab Create(BookCab model) {
		Optional<BookCab> result = bookCabRepository.findById(model.getId());
		if (result.isPresent()) {
			return result.get();
		} else {
			model.setCreatedDate(LocalDateTime.now());
			bookCabRepository.save(model);
			return model;
		}
	}

	public Pair<Boolean, String> Update(int id) {
		Optional<BookCab> result = bookCabRepository.findById(id);
		if (result.isPresent()) {
			BookCab model = result.get();
			if (model.getFinishedDate() != null)
				return new Pair<Boolean, String>(false, "Trip is already finished");
			model.setFinishedDate(LocalDateTime.now());
			bookCabRepository.save(model);
			return new Pair<Boolean, String>(true, "Trip is finished");
		} else {
			return new Pair<Boolean, String>(false, "Trip not found");
		}
	}
}
