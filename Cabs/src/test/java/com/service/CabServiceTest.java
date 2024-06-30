package com.service;

import com.dto.CabFareDto;
import com.dto.CabPagedListRequestDto;
import com.entity.Cab;
import com.mapping.CabFareMapping;
import com.repository.CabRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.javatuples.Pair;

class CabServiceTest {

    @Mock
    private CabPagedListRequestDto search;

    @InjectMocks
    private CabService cabService;

    @InjectMocks
    private CabFareMapping cabFareMapping;

    @Mock
    private CabRepository cabRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void create_returnsCreatedCab() {
        // Arrange
        Cab cab = new Cab();
        cab.setId(1);
        cab.setIsAvailable(true);

        when(cabRepository.findById(1)).thenReturn(Optional.empty());
        when(cabRepository.save(cab)).thenReturn(cab);

        // Act
        Cab result = cabService.Create(cab);

        // Assert
        assertEquals(cab, result);
        verify(cabRepository, times(1)).findById(1);
        verify(cabRepository, times(1)).save(cab);
    }

    @Test
    void update_returnsUpdatedCabStatus() {
        // Arrange
        int id = 1;
        boolean isAvailable = true;
        Cab cab = new Cab();
        cab.setId(id);
        cab.setIsAvailable(!isAvailable);

        when(cabRepository.findById(id)).thenReturn(Optional.of(cab));
        when(cabRepository.save(cab)).thenReturn(cab);

        // Act
        Pair<Boolean, String> result = cabService.Update(id, isAvailable);

        // Assert
        assert (result.getValue0());
        assertEquals(isAvailable ? "Cab status is available" : "Cab status is not available", result.getValue1());
        verify(cabRepository, times(1)).findById(id);
        verify(cabRepository, times(1)).save(cab);
    }

    @Test
    void isAvailable_returnsCabAvailability() {
        // Arrange
        int id = 1;
        Cab cab = new Cab();
        cab.setId(id);
        cab.setIsAvailable(true);

        when(cabRepository.findById(id)).thenReturn(Optional.of(cab));

        // Act
        boolean result = cabService.IsAvailable(id);

        // Assert
        assert (result);
        verify(cabRepository, times(1)).findById(id);
    }

    @Test
    void getFare_returnsCabFareDto() {
        // Arrange
        int id = 1;
        Map<String, Object> data = new HashMap<>();
        // Add necessary data to the map

        when(cabRepository.getFareById(id)).thenReturn(data);
        when(cabFareMapping.ToDto(data)).thenReturn(new CabFareDto());

        // Act
        CabFareDto result = cabService.GetFare(id);

        // Assert
        assertNotNull(result);
        verify(cabRepository, times(1)).getFareById(id);
        verify(cabFareMapping, times(1)).ToDto(data);
    }

    @Test
    void getById_returnsCabById() {
        // Arrange
        int id = 1;
        Cab cab = new Cab();
        cab.setId(id);

        when(cabRepository.findById(id)).thenReturn(Optional.of(cab));

        // Act
        Cab result = cabService.GetById(id);

        // Assert
        assertEquals(cab, result);
        verify(cabRepository, times(1)).findById(id);
    }
}