package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

class CatTest {

    @Mock
    Feline feline;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.openMocks(this);

    }
    @Test
    void getSound(){
        assertEquals("Мяу", new Cat(feline).getSound());
    }

    @Test
    void getFood() throws Exception {
        assertDoesNotThrow(
                () -> new Cat(feline).getFood()
        );
        Mockito.verify(feline).eatMeat();
    }

}