package com.mapping;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dto.CabFareDto;
import com.viewmodel.CabFareViewModel;

@Service
public class CabFareMapping {
	public CabFareViewModel ToViewModel(CabFareDto model) {
		return new CabFareViewModel(model.getId(), model.getDriverName(), model.getFare());
	}

	public CabFareDto ToDto(Map<String, Object> model) {
		return new CabFareDto(
				(Integer) model.get("id"),
				(String) model.get("driverName"),
				((BigDecimal) model.get("fare")).longValue());
	}
}
