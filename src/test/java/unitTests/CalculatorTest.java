package unitTests;

import cloud.ez2learn.seleniumproj.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;



class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(2, 3);
    }

    @Test
    public void testSum() {
        assertEquals(5, calculator.getSum());
    }

    // @Test
    // public void testDifference() {
    //     assertEquals(-1, calculator.getDifference());
    // }

}