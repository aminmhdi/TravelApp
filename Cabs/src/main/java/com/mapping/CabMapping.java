package com.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.CabPagedListResponseDto;
import com.entity.Cab;
import com.viewmodel.CabPagedListViewModel;
import com.viewmodel.CabRequestViewModel;
import com.viewmodel.CabViewModel;

@Service
public class CabMapping {
	public Cab ToDataModel(CabRequestViewModel model) {
		Cab dataModel = new Cab(
				0,
				model.getDriverName(),
				model.getType(),
				model.getFrom(),
				model.getTo(),
				model.getAmount(),
				true);
		return dataModel;
	}

	public CabViewModel ToViewModel(Cab model) {
		CabViewModel viewModel = new CabViewModel();
		if (model == null)
			return viewModel;
		viewModel.setId(model.getId());
		viewModel.setIsAvailable(model.getIsAvailable());
		viewModel.setType(model.getType());
		viewModel.setAmount(model.getAmount());
		viewModel.setDriverName(model.getDriverName());
		viewModel.setFrom(model.getCabFrom());
		viewModel.setTo(model.getCabTo());
		return viewModel;
	}

	public List<CabViewModel> ToViewModel(List<Cab> model) {
		List<CabViewModel> result = new ArrayList<CabViewModel>();
		for (Cab cab : model)
			result.add(ToViewModel(cab));
		return result;
	}

	public CabPagedListViewModel ToPagedListViewModel(CabPagedListResponseDto model) {
		return new CabPagedListViewModel(ToViewModel(model.getList()), model.totalPages);
	}
}
