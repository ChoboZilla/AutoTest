package org.example;

//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertTrue;

import com.epam.tat.module4.Calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    static Calculator calc;

    @BeforeAll
    public static void start() {
        calc = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "0, 3.14", "0, 6.28", "1, 1.57", "0, -3.14", "0, -6.28", "0.7, 0.785", "-0.959, 5",
            "1, 1.57", "-2.4492935982947064E-16, 4.94065645841246544e-324d", "0.004, 1.79769313486231570e+308d" })
    public void testSin(double exp, double par) {
        assertEquals(exp, calc.sin(par + 2 * Math.PI), 0.009);
    }

    @ParameterizedTest
    @CsvSource({"0.13, 0.131", "-0.13, -0.131"})
    public void testSinBorder(double exp, double par) {
        assertEquals(exp, calc.sin(par), 0.009);
    }
/////////////////////////////////////
    @ParameterizedTest
    @CsvSource({"1, 2, 2", "0.5, 5, 10", "2, 0.8, 0.4", "-2, -4, 2", "-2, 4, -2",
            "9223372036854775807, 9223372036854775807, 1", "-9223372036854775807, 9223372036854775807, -1"})
    public void testDiv(double exp, double a, double b) {
        assertEquals(exp, calc.div(a, b), 0.009);
    }

    @Test
    public void testDivByZero() {
        assertThrows(NumberFormatException.class, () -> {
            calc.div(5, 0);
       });
    }
//////////////////////////////////////
    @ParameterizedTest
    @CsvSource({"2, 4", "1.41, 2", "1.41, -2", "2, -4", "0.4, 0.16", "0.4, -0.16", "0, 0"})
    public void testSqrt(double exp, double a) {
        assertEquals(exp, calc.sqrt(a), 0.009);
    }
    @ParameterizedTest
    @CsvSource({"1.41, -2", "2, -4", "0.4, -0.16"})
    public void testSqrtNeg(double notExp, double a) { //Why is there no exception??
        assertThrows(Exception.class, () -> {
            calc.sqrt(a);
        });
        //assertEquals(notExp, calc.sqrt(a), 0.009);
    }
/////////////////////////////////////
    @ParameterizedTest
    @CsvSource({"false, 4", "true, -1000", "false, 0", "false, 9223372036854775807", "true, -9223372036854775807"})
    public void testIsNegEq(boolean exp, long a) {
        assertEquals(exp, calc.isNegative(a));
    }

    @ParameterizedTest
    @CsvSource({"true, 5", "false, -50", "true, 0"})
    public void testIsNegNotEq(boolean exp, long a) {
        assertNotEquals(exp, calc.isNegative(a));
    }
}
