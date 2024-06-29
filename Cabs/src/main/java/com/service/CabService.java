package com.service;

import java.util.Optional;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.dto.CabPagedListRequestDto;
import com.dto.CabPagedListResponseDto;
import com.entity.Cab;
import com.repository.CabRepository;
import com.repository.specification.CabSpecification;

@Service
public class CabService {
    @Autowired
    CabRepository cabRepository;

    public CabPagedListResponseDto List(CabPagedListRequestDto search) {
        Direction order = search.getOrder() == "asc" ? Direction.ASC : Direction.DESC;
        Pageable pageable = PageRequest.of(search.getPageNumber() - 1, search.getPageSize(), order, search.orderBy);
        Specification<Cab> spec = GetListQuery(search);
        Page<Cab> result = cabRepository.findAll(spec, pageable);
        return new CabPagedListResponseDto(result.toList(), result.getTotalPages());
    }

    private Specification<Cab> GetListQuery(CabPagedListRequestDto search) {
        Specification<Cab> spec = Specification.where(null);
        if (search.getType() != null)
            spec = spec.and(CabSpecification.hasType(search.getType()));

        if (search.getAmountFrom() != null)
            spec = spec.and(CabSpecification.hasAmountFrom(search.getAmountFrom()));

        if (search.getAmountTo() != null)
            spec = spec.and(CabSpecification.hasAmountTo(search.getAmountTo()));

        if (search.getFrom() != null && !search.getFrom().isBlank())
            spec = spec.and(CabSpecification.hasFrom(search.getFrom()));

        if (search.getTo() != null && !search.getTo().isBlank())
            spec = spec.and(CabSpecification.hasTo(search.getTo()));

        if (search.getIsAvailable() != null)
            spec = spec.and(CabSpecification.hasAvailable(search.getIsAvailable()));

        return spec;
    }

    public Cab Create(Cab model) {
        Optional<Cab> result = cabRepository.findById(model.getId());
        if (result.isPresent()) {
            return result.get();
        } else {
            cabRepository.save(model);
            return model;
        }
    }

    public Pair<Boolean, String> Update(int id, boolean isAvailable) {
        Optional<Cab> result = cabRepository.findById(id);
        if (result.isPresent()) {
            Cab model = result.get();
            if (model.getIsAvailable() == isAvailable)
                return new Pair<Boolean, String>(false, "There is no change");
            model.setIsAvailable(isAvailable);
            cabRepository.save(model);
            return new Pair<Boolean, String>(true,
                    (isAvailable ? "Cab status is available" : "Cab status is not available"));
        } else
            return new Pair<Boolean, String>(false, "Cab not found");
    }

    public boolean IsAvailable(int id) {
        Optional<Cab> result = cabRepository.findById(id);
        if (result.isPresent()) {
            Cab model = result.get();
            return model.getIsAvailable();
        } else
            return false;
    }
}
