package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticCalculatorTest {

    private final ArithmeticCalculator calculator = new ArithmeticCalculator();

    @Test
    public void testAdd() {
        assertEquals(calculator.add(5, 3), 8);
    }

    @Test
    public void testSubtract() {
        assertEquals(calculator.subtract(5, 3), 2);
    }

    @Test
    public void testMultiply() {
        assertEquals(calculator.multiply(5, 3), 15);
    }

    @Test
    public void testDivide() {
        assertEquals(calculator.divide(5, 2), 2.5);
    }
}
