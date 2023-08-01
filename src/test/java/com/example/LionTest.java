package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class LionTest {

    @Mock
    Feline feline;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void setWhenSamecThenTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void setWhenSamkaThenFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void setWhenNotSamkaAndNotSamecThenExceptionThrown() throws Exception {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Самей", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }


    @Test
    void getFood() throws Exception {
        assertDoesNotThrow(
                () -> new Lion("Самец", feline).getFood()
        );
        Mockito.verify(feline).getFood(anyString());
    }

    @Test
    void getKittens() {
        assertDoesNotThrow(
                () -> new Lion("Самец", feline).getKittens()
        );
        Mockito.verify(feline).getKittens();
    }
}