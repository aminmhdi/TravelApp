package com.mapping;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.entity.BookCab;
import com.viewmodel.BookCabRequestViewModel;
import com.viewmodel.BookCabResponseViewModel;

@Service
public class BookCabMapping {
	public BookCab ToDataModel(BookCabRequestViewModel model) {
		BookCab dataModel = new BookCab();
		dataModel.setCabId(model.getCabId());
		dataModel.setCreatedDate(LocalDateTime.now());
		dataModel.setEmail(model.getEmail());
		return dataModel;
	}

	public BookCabResponseViewModel ToViewModel(BookCab model) {
		BookCabResponseViewModel viewModel = new BookCabResponseViewModel();
		if (model == null)
			return viewModel;
		viewModel.setBookId(model.getId());
		return viewModel;
	}
}
