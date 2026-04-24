package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;
    @BeforeEach
    public void setup() {
        calculator = new DoubleCalculator();
        calculator.init();
    }
    @Test
    public void testAddPositive() {
        double a = 10.5;
        calculator.add(a);
        Assertions.assertEquals(10.5, calculator.result(), 0.001);
    }
    @Test
    public void testAddNegatives() {
        calculator.add(-5.0).add(-2.0);
        Assertions.assertEquals(-7.0, calculator.result(), 0.001);
    }
    @Test
    public void testSubtractPositives() {
        calculator.add(20.0);
        calculator.subtract(5.0);
        Assertions.assertEquals(15.0, calculator.result(), 0.001);
    }
    @Test
    public void testSubtractNegatives() {
        calculator.add(10.0);
        calculator.subtract(-2.0); // 10 - (-2) = 12
        Assertions.assertEquals(12.0, calculator.result(), 0.001);
    }
    @Test
    public void testMultiplyBy0() {
        calculator.add(100.0);
        calculator.multiply(0.0);
        Assertions.assertEquals(0.0, calculator.result(), 0.001);
    }
    @Test
    public void testDividePositives() {
        calculator.add(10.0);
        calculator.divide(4.0);
        Assertions.assertEquals(2.5, calculator.result(), 0.001);
    }
    @Test
    public void testDivideBy0() {
        calculator.add(10.0);
        calculator.divide(0.0);
        double rezultat = (double) calculator.result();
        Assertions.assertFalse(Double.isFinite(rezultat), "Rezultatul ar trebui să fie Infinity sau NaN la împărțirea cu 0");
    }
}
