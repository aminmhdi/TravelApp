package com.mapping;

import org.springframework.stereotype.Service;

import com.dto.CabFareDto;
import com.viewmodel.CabFareViewModel;

@Service
public class CabFareMapping {
    public CabFareViewModel ToViewModel(CabFareDto model) {
        CabFareViewModel dataModel = new CabFareViewModel(model.getId(), model.getDriverName(), model.getFare());
        return dataModel;
    }
}
