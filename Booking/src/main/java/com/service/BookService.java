package com.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.BookCab;
import com.repository.BookRepository;
import com.viewmodel.CabUpdateRequestViewModel;

@Service
public class BookService {
	@Autowired
	BookRepository bookCabRepository;

	@Autowired
	RestTemplate restTemplate;

	public BookCab Create(BookCab model) {
		if (!isCabAvailable(model.getCabId()))
			return null;

		Integer id = bookCabRepository.getByCabId(model.getCabId());
		if (id != null) {
			Optional<BookCab> result = bookCabRepository.findById(id.intValue());
			return result.get();
		} else {
			model.setCreatedDate(LocalDateTime.now());
			bookCabRepository.save(model);
			setCabAvailable(model.getCabId(), false);
			return model;
		}
	}

	private boolean isCabAvailable(int id) {
		try {
			String cabUrl = "http://localhost:8282/cab/isAvailable/" + id;
			Boolean isAvailable = restTemplate.getForObject(cabUrl, Boolean.class);
			return isAvailable != null ? isAvailable.booleanValue() : false;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			return false;
		}
	}

	private void setCabAvailable(int id, boolean isAvailable) {
		try {
			String cabUrl = "http://localhost:8282/cab";
			CabUpdateRequestViewModel request = new CabUpdateRequestViewModel(id, isAvailable);
			restTemplate.put(cabUrl, request);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
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
			setCabAvailable(id, true);
			return new Pair<Boolean, String>(true, "Trip is finished");
		} else {
			return new Pair<Boolean, String>(false, "Trip not found");
		}
	}
}
