package com.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.dto.CabPagedListRequestDto;
import com.dto.CabPagedListResponseDto;
import com.entity.Cab;
import com.mapping.CabMapping;
import com.service.CabService;
import com.viewmodel.CabPagedListViewModel;
import com.viewmodel.CabRequestViewModel;
import com.viewmodel.CabViewModel;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CabControllerTest {

    @Mock
    private CabService service;

    @Mock
    private CabMapping cabMapping;

    @InjectMocks
    private CabController controller;

    @BeforeEach
    void setUp() {
        // Setup mock behavior here if needed for each test
    }

    @Test
    void list_returnsCabPagedListViewModel() {
        // Arrange
        CabPagedListRequestDto requestDto = new CabPagedListRequestDto();
        CabPagedListResponseDto responseDto = new CabPagedListResponseDto(new ArrayList<Cab>(), 1);
        CabPagedListViewModel mockViewModel = new CabPagedListViewModel(new ArrayList<CabViewModel>(), 1); // Assume
                                                                                                           // CabPagedListViewModel
                                                                                                           // is a valid
        // class
        when(service.List(requestDto)).thenReturn(responseDto);
        when(cabMapping.ToPagedListViewModel(responseDto)).thenReturn(mockViewModel);

        // Act
        CabPagedListViewModel result = controller.list(requestDto);

        // Assert
        assertNotNull(result);
        assertEquals(mockViewModel, result);
        verify(service).List(requestDto);
        verify(cabMapping).ToPagedListViewModel(responseDto);
    }

    @Test
    void create_returnsResponseEntityWithCabViewModel() {
        // Arrange
        CabRequestViewModel requestViewModel = new CabRequestViewModel();
        requestViewModel.setDriverName("John Doe");
        requestViewModel.setFrom("Location A");
        requestViewModel.setTo("Location B");
        requestViewModel.setType(1);
        requestViewModel.setAmount(10);

        Cab cab = new Cab(1, "John Doe", 1, "Location A", "Location B", 10, true);
        CabViewModel expectedViewModel = new CabViewModel(1, true); // Assume CabViewModel is a valid class;

        when(service.Create(any())).thenReturn(cab);
        when(cabMapping.ToViewModel(cab)).thenReturn(expectedViewModel);

        // Act
        ResponseEntity<Object> response = controller.create(requestViewModel);

        // Assert
        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals(expectedViewModel, response.getBody());
        verify(service).Create(any());
        verify(cabMapping).ToViewModel(cab);
    }
}