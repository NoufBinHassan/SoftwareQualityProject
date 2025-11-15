package edu.pnu.badcalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add_shouldReturnCorrectSum() {
        Calculator c = new Calculator();
        assertEquals(5.0, c.add(2.0, 3.0));
    }

    @Test
    void subtract_shouldReturnCorrectResult() {
        Calculator c = new Calculator();
        assertEquals(1.0, c.subtract(4.0, 3.0));
    }

    @Test
    void multiply_shouldReturnCorrectResult() {
        Calculator c = new Calculator();
        assertEquals(12.0, c.multiply(3.0, 4.0));
    }

    @Test
    void divide_shouldReturnQuotient() {
        Calculator c = new Calculator();
        assertEquals(2.5, c.divide(5.0, 2.0));
    }

    @Test
    void divide_shouldThrowOnZero() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class,
                () -> c.divide(10, 0));
    }

    @Test
    void factorial_shouldReturnCorrectValue() {
        Calculator c = new Calculator();
        assertEquals(120, c.factorial(5));
    }

    @Test
    void factorial_shouldThrowOnNegative() {
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class,
                () -> c.factorial(-1));
    }
    @Test
void add_shouldHandleNegativeNumbers() {
    Calculator c = new Calculator();
    assertEquals(-1.0, c.add(2.0, -3.0));
}

@Test
void subtract_shouldHandleNegativeResult() {
    Calculator c = new Calculator();
    assertEquals(-7.0, c.subtract(-4.0, 3.0));
}

@Test
void multiply_shouldHandleZero() {
    Calculator c = new Calculator();
    assertEquals(0.0, c.multiply(5.0, 0.0));
}

@Test
void divide_shouldHandleFractions() {
    Calculator c = new Calculator();
    assertEquals(0.5, c.divide(1.0, 2.0));
}

@Test
void factorial_shouldReturnOneForZero() {
    Calculator c = new Calculator();
    assertEquals(1, c.factorial(0));
}

@Test
void main_shouldRunWithoutErrors() {
    App.main(new String[]{});
}
}

