package com.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.dto.CabFareDto;
import com.mapping.CabFareMapping;
import com.service.CabFareService;
import com.viewmodel.CabFareViewModel;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CabControllerTest {

    @Mock
    private CabFareService service;

    @Mock
    private CabFareMapping cabFareMapping;

    @InjectMocks
    private CabController controller;

    @BeforeEach
    void setUp() {
        // Setup mock behavior here if needed for each test
    }

    @Test
    void fare_whenFareExists_returns200AndFare() {
        // Arrange
        int id = 1;
        CabFareDto mockFareDto = new CabFareDto(); // Assume CabFareDto is a valid class
        when(service.Get(id)).thenReturn(mockFareDto);
        when(cabFareMapping.ToViewModel(mockFareDto)).thenReturn((CabFareViewModel) new Object()); // Assuming
                                                                                                   // ToViewModel
                                                                                                   // returns an Object

        // Act
        ResponseEntity<Object> response = controller.fare(id);

        // Assert
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(service).Get(id);
        verify(cabFareMapping).ToViewModel(mockFareDto);
    }

    @Test
    void fare_whenFareDoesNotExist_returns404() {
        // Arrange
        int id = 1;
        when(service.Get(id)).thenReturn(null);

        // Act
        ResponseEntity<Object> response = controller.fare(id);

        // Assert
        assertEquals(404, response.getStatusCode());
        assertNull(response.getBody());
        verify(service).Get(id);
    }
}