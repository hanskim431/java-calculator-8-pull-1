package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ParserTest {
    
    @Test
    void 해피_패스_기본_구분자_직렬화(){
        // Given
        String inputText = "1,2,3:4";
        List<Positive> positives = new ArrayList<>();
        Delimiter delimiter = new Delimiter();

        // When
        Parser parser = new Parser(inputText, positives, delimiter);

        // Then
        assertEquals(1L, positives.get(0).getNumber());
        assertEquals(2L, positives.get(1).getNumber());
        assertEquals(3L, positives.get(2).getNumber());
        assertEquals(4L, positives.get(3).getNumber());
    }
    @Test
    void 공백_문자_기본_구분자_직렬화(){
        // Given
        String inputText = "";
        List<Positive> positives = new ArrayList<>();
        Delimiter delimiter = new Delimiter();

        // When
        Parser parser = new Parser(inputText, positives, delimiter);

        // Then
        assertTrue(positives.isEmpty());
    }


}