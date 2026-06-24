package lesson7;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NumberComparatorTest {

    private final NumberComparator comparator = new NumberComparator();

    @Test
    public void testFirstNumberIsGreater() {
        assertEquals(comparator.compare(10, 5), 1);
    }

    @Test
    public void testFirstNumberIsLess() {
        assertEquals(comparator.compare(5, 10), -1);
    }

    @Test
    public void testNumbersAreEqual() {
        assertEquals(comparator.compare(5, 5), 0);
    }
}
