package com.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.entity.BookCab;
import com.viewmodel.BookRequestViewModel;
import com.viewmodel.BookResponseViewModel;

@Service
public class BookMapping {
	public BookCab ToDataModel(BookRequestViewModel model) {
		BookCab dataModel = new BookCab();
		dataModel.setCabId(model.getCabId());
		dataModel.setCreatedDate(LocalDateTime.now());
		dataModel.setEmail(model.getEmail());
		return dataModel;
	}

	public BookResponseViewModel ToViewModel(BookCab model) {
		BookResponseViewModel viewModel = new BookResponseViewModel(null);
		if (model == null)
			return viewModel;
		viewModel.setBookId(model.getId());
		return viewModel;
	}
}
