package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorAppTest {

    @Test
    void add() {
        //arrange
        CalculatorApp kalkulator = new CalculatorApp();

        //act
        int sumaInt = kalkulator.add(2, 3);

        //assert
        assertEquals(5, sumaInt, "Sprawdzanie poprawnego dodawania liczb calkowitych");
    }

    @Test
    void addDouble() {
        //arrange
        CalculatorApp kalkulator = new CalculatorApp();

        //act
        double sumaDouble = kalkulator.add(2.01, 3.04);

        //assert
        assertEquals(5.05, sumaDouble, 0.00001, "Sprawdzanie poprawnego dodawania liczb zmiennoprzecinkowwych");
    }

    @Test
    void division() {
        //arrange
        CalculatorApp kalkulator = new CalculatorApp();

        //act
        double divisionResult = kalkulator.division(3, 0.5);

        //assert
        assertEquals(6.00, divisionResult, 0.0000001, "Sprawdzanie poprawnego dzieleniea liczb zmiennoprzecinkowych");
    }

    @Test
    void divisionInt() {
        //arrange
        CalculatorApp kalkulator = new CalculatorApp();

        //act
        int divisionResult = kalkulator.division(3, 2);

        //assert
        assertEquals(1, divisionResult, "Sprawdzanie poprawnego dzieleniea liczb calkowitych");
    }
}