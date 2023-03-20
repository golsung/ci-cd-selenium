package unitTests;

import cloud.ez2learn.seleniumproj.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;



class CalculatorTest {

//    private Calculator calculator;

//    @BeforeEach
//    void setUp() {
//
//        calculator = new Calculator();
//    }

    @Test
    public void testSum1() {
        Calculator calculator = new Calculator();
        calculator.setLeftOperand(2);
        calculator.setRightOperand(3);
        assertEquals(5, calculator.getSum());
    }

    @Test
    public void testSum2() {
        Calculator calculator = new Calculator();
        calculator.setLeftOperand(12);
        calculator.setRightOperand(13);
        assertEquals(25, calculator.getSum());
    }

     @Test
     public void testDifference1() {
         Calculator calculator = new Calculator();
         calculator.setLeftOperand(12);
         calculator.setRightOperand(13);
         assertEquals(-1, calculator.getDifference());
     }

    public void testDifference2() {
        Calculator calculator = new Calculator();
        calculator.setLeftOperand(0);
        calculator.setRightOperand(5);
        assertEquals(-5, calculator.getDifference());
    }

}