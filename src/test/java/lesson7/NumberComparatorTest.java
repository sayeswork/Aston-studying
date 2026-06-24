package lesson7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComparatorTest {

    private final NumberComparator comparator = new NumberComparator();

    @Test
    void testFirstNumberIsGreater() {
        assertEquals(1, comparator.compare(10, 5));
    }

    @Test
    void testFirstNumberIsLess() {
        assertEquals(-1, comparator.compare(5, 10));
    }

    @Test
    void testNumbersAreEqual() {
        assertEquals(0, comparator.compare(5, 5));
    }
}
