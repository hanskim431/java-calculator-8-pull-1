package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void 빈_문자열_계산() {
        //Given
        String inputText = "";

        //When
        Calculator calculator = new Calculator(inputText);

        //Then
        assertEquals(calculator.getResult(), 0);
    }

    @Test
    void 단일_숫자_덧셈_계산() {
        //Given
        String inputText = "1";

        //When
        Calculator calculator = new Calculator(inputText);

        //Then
        assertEquals(calculator.getResult(), 1);
    }

    @Test
    void 복수_숫자_덧셈_계산() {
        //Given
        String inputText = "1,2,3:4:5";

        //When
        Calculator calculator = new Calculator(inputText);

        //Then
        assertEquals(calculator.getResult(), 15);
    }
}