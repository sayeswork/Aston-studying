package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAreaCalculatorTest {

    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    void testTriangleArea() {
        assertEquals(10.0, calculator.calculate(5.0, 4.0));
    }

    @Test
    void testTriangleAreaWithFractionalNumbers() {
        assertEquals(3.75, calculator.calculate(2.5, 3.0));
    }
}
