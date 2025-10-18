package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 기본_구분자_정규표현식_반환() {
        Delimiter delimiter = new Delimiter();
        String delimiterRegex = delimiter.getDelimiterRegex();
        assertEquals("[,:]", delimiterRegex);
    }

}