package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    void testFactorial() {
        assertEquals(120, calculator.calculate(5));
    }

    @Test
    void testZeroFactorial() {
        assertEquals(1, calculator.calculate(0));
    }
}
