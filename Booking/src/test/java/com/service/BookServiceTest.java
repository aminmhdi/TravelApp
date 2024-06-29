package com.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.javatuples.Pair;

import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import com.entity.BookCab;
import com.repository.BookRepository;

public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @InjectMocks
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        // Setup mock behavior here if needed for each test
        bookRepository = mock(BookRepository.class);
        bookService = mock(BookService.class);
    }

    @Test
    public void create_WhenCabIsAvailable_ShouldCreateBooking() {
        // Arrange
        BookCab bookCab = new BookCab(1, "amin.mohammadi@vodafone.com", 1, LocalDateTime.now(), null); // Not finished
        when(bookService.Create(bookCab)).thenReturn(bookCab);
        when(bookRepository.save(bookCab)).thenReturn(bookCab);

        // Act
        BookCab result = bookService.Create(bookCab);

        // Assert
        assertNotNull(result);
        assertEquals(bookCab, result);
    }

    @Test
    public void create_WhenCabIsNotAvailable_ShouldReturnNull() {
        // Arrange
        BookCab bookCab = new BookCab(1, "amin.mohammadi@vodafone.com", 1, LocalDateTime.now(), null); // Not finished
        when(bookService.Create(bookCab)).thenReturn(null);

        // Act
        BookCab result = bookService.Create(bookCab);

        // Assert
        assertNull(result);
        verify(bookRepository, never()).save(bookCab);
    }

    @Test
    public void update_WhenBookingExistsAndNotFinished_ShouldFinishTrip() {
        // Arrange
        int id = 1;
        BookCab bookCab = new BookCab(1, "amin.mohammadi@vodafone.com", 1, LocalDateTime.now(), null); // Not finished
        when(bookRepository.findById(id)).thenReturn(Optional.of(bookCab));
        when(bookService.Update(id)).thenReturn(Pair.with(true, "Trip is finished"));
        when(bookRepository.save(bookCab)).thenReturn(bookCab);

        // Act
        Pair<Boolean, String> result = bookService.Update(id);

        // Assert
        assertTrue(result.getValue0());
        assertEquals("Trip is finished", result.getValue1());
    }

    @Test
    public void update_WhenBookingExistsAndFinished_ShouldReturnError() {
        // Arrange
        int id = 2;
        BookCab bookCab = new BookCab();
        bookCab.setFinishedDate(LocalDateTime.now()); // Already finished
        when(bookRepository.findById(id)).thenReturn(Optional.of(bookCab));
        when(bookService.Update(id)).thenReturn(Pair.with(false, "Trip is already finished"));

        // Act
        Pair<Boolean, String> result = bookService.Update(id);

        // Assert
        assertFalse(result.getValue0());
        assertEquals("Trip is already finished", result.getValue1());
        verify(bookRepository, never()).save(bookCab);
    }

    @Test
    public void update_WhenBookingDoesNotExist_ShouldReturnError() {
        // Arrange
        int id = 3;
        when(bookRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Pair<Boolean, String> result = bookService.Update(id);

        // Assert
        assertNull(result);
        verify(bookRepository, never()).save(any(BookCab.class));
    }
}