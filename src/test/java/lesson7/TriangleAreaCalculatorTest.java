package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaCalculatorTest {

    private final TriangleAreaCalculator calculator = new TriangleAreaCalculator();

    @Test
    public void testTriangleArea() {
        assertEquals(calculator.calculate(5.0, 4.0), 10.0);
    }

    @Test
    public void testTriangleAreaWithFractionalNumbers() {
        assertEquals(calculator.calculate(2.5, 3.0), 3.75);
    }
}
