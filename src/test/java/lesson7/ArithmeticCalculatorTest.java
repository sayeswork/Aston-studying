package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticCalculatorTest {

    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    @Test
    void testAdd() {
        assertEquals(8, calculator.add(5, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2));
    }
}
