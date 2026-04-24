package ro.ulbs.proiectaresoftware.lab6.advanced;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewIntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new NewIntCalculator();
        calculator.init();
    }

    @Test
    public void testAddPositive() {
        calculator.add(10);
        Assertions.assertEquals(10, calculator.result());
    }

    @Test
    public void testAddNegative() {
        calculator.add(-5).add(-2);
        Assertions.assertEquals(-7, calculator.result());
    }
    @Test
    public void testSubtractPositives() {
        calculator.add(20);
        calculator.subtract(5);
        Assertions.assertEquals(15, calculator.result());
    }
    @Test
    public void testSubtractNegative() {
        calculator.add(10);
        calculator.subtract(-5);
        Assertions.assertEquals(15, calculator.result());
    }
    @Test
    public void testMultiplyPositives() {
        calculator.add(4);
        calculator.multiply(3);
        Assertions.assertEquals(12, calculator.result());
    }
    @Test
    public void testMultiplyBy0() {
        calculator.add(10);
        calculator.multiply(0);
        Assertions.assertEquals(0, calculator.result());
    }
    @Test
    public void testDividePositives() {
        calculator.add(20);
        calculator.divide(5);
        Assertions.assertEquals(4, calculator.result());
    }
    @Test
    public void testDivideNegatives() {
        calculator.add(-20);
        calculator.divide(5);
        Assertions.assertEquals(-4, calculator.result());
    }
    @Test
    public void testDivideByZero() {
        calculator.add(10);
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0);
        }, "Împărțirea la zero: ");
    }
}