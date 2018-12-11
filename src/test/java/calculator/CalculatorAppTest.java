package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorAppTest {

    @Test
    void add() {
        //arrange
        CalculatorApp kalkulator = new CalculatorApp();

        //act
        int suma = kalkulator.add(2,3);

        //assert
        Assertions.assertEquals(5, suma, "Sprawdzanie poprawnego dodawania liczb calkowitych");
    }
}