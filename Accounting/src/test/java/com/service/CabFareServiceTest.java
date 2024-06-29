package com.service;

import com.dto.CabFareDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CabFareServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CabFareService cabFareService;

    @BeforeEach
    void setUp() {
        // Setup mock behavior here if needed for each test
    }

    @Test
    void get_whenFareExists_returnsFareDto() {
        // Arrange
        int id = 1;
        CabFareDto expectedFare = new CabFareDto(); // Assume CabFareDto is a valid class with proper equals/hashCode
        String url = "http://localhost:8282/cab/fare/" + id;
        when(restTemplate.getForObject(url, CabFareDto.class)).thenReturn(expectedFare);

        // Act
        CabFareDto actualFare = cabFareService.Get(id);

        // Assert
        assertEquals(expectedFare, actualFare);
        verify(restTemplate).getForObject(url, CabFareDto.class);
    }

    @Test
    void get_whenExceptionOccurs_returnsNull() {
        // Arrange
        int id = 1;
        String url = "http://localhost:8282/cab/fare/" + id;
        when(restTemplate.getForObject(url, CabFareDto.class)).thenThrow(new RuntimeException("Service unavailable"));

        // Act
        CabFareDto actualFare = cabFareService.Get(id);

        // Assert
        assertNull(actualFare);
        verify(restTemplate).getForObject(url, CabFareDto.class);
    }
}