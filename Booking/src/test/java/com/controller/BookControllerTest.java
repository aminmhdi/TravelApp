package com.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.entity.BookCab;
import com.mapping.BookMapping;
import com.service.BookService;
import com.viewmodel.BookRequestViewModel;
import com.viewmodel.BookResponseViewModel;

import static org.mockito.Mockito.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    private BookService service;

    @Mock
    private BookMapping bookMapping;

    @InjectMocks
    private BookController controller;

    @BeforeEach
    void setUp() {
        // Setup mock behavior here if needed for each test
    }

    @Test
    void book_whenBookingIsSuccessful_returns200AndBooking() {
        // Arrange
        BookRequestViewModel request = new BookRequestViewModel("amin.mohammadi@vodafone.com", 1);
        // Assume BookResponseViewModel is a valid class
        BookResponseViewModel mockResponse = new BookResponseViewModel(1);
        BookCab serviceResponse = new BookCab(1, "amin.mohammadi@vodafone.com", 1, LocalDateTime.now(), null);
        when(service.Create(bookMapping.ToDataModel(request))).thenReturn(serviceResponse);
        when(bookMapping.ToViewModel(serviceResponse)).thenReturn(mockResponse);

        // Act
        ResponseEntity<Object> response = controller.bookCab(request);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
        verify(service).Create(bookMapping.ToDataModel(request));
        verify(bookMapping).ToViewModel(serviceResponse);
    }

    @Test
    void book_whenBookingIsNotSuccessful_returns404() {
        // Arrange
        BookRequestViewModel request = new BookRequestViewModel("amin.mohammadi@vodafone.com", 1);
        when(service.Create(bookMapping.ToDataModel(request))).thenReturn(null);

        // Act
        ResponseEntity<Object> response = controller.bookCab(request);

        // Assert
        assertEquals(400, response.getStatusCode().value());
        assertEquals(response.getBody(), "Cab is not available now!");
        verify(service).Create(bookMapping.ToDataModel(request));
    }

    @Test
    void book_whenRequestIsNull_returns400() {
        // Arrange
        BookRequestViewModel request = null;

        // Act
        ResponseEntity<Object> response = controller.bookCab(request);

        // Assert
        assertEquals(400, response.getStatusCode().value());
        assertEquals(response.getBody(), "Your cab id or email is not valid");
    }

    @Test
    void endTrip_whenTripEndsSuccessfully_returns200() {
        // Arrange
        int bookId = 1;
        when(service.Update(bookId)).thenReturn(new org.javatuples.Pair<>(true, "Trip ended successfully"));

        // Act
        ResponseEntity<String> response = controller.endTrip(bookId);

        // Assert
        assertEquals(200, response.getStatusCode().value());
        assertEquals(response.getBody(), "Trip ended successfully");
        verify(service).Update(bookId);
    }

    @Test
    void endTrip_whenTripEndsUnsuccessfully_returns400() {
        // Arrange
        int bookId = 1;
        when(service.Update(bookId)).thenReturn(new org.javatuples.Pair<>(false, "Trip could not be ended"));

        // Act
        ResponseEntity<String> response = controller.endTrip(bookId);

        // Assert
        assertEquals(400, response.getStatusCode().value());
        assertEquals(response.getBody(), "Trip could not be ended");
        verify(service).Update(bookId);
    }
}