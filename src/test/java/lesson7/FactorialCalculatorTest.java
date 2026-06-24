package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialCalculatorTest {

    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testFactorial() {
        assertEquals(calculator.calculate(5), 120);
    }

    @Test
    public void testZeroFactorial() {
        assertEquals(calculator.calculate(0), 1);
    }
}
