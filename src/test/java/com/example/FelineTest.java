package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    @Test
    void eatMeat() throws Exception {
        assertLinesMatch(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void getFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void getKittens() {
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1, Integer.MAX_VALUE, Integer.MIN_VALUE})
    // FIXME метод реализован не правильно, тк он позволяет ввести отрицательные значения в метод получения кол-ва котят
    void testGetKittens(int kittensCount) {
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}