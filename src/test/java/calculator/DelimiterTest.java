package calculator;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DelimiterTest {

    @Test
    void 기본_구분자_정규표현식_반환() {
        Delimiter delimiter = new Delimiter();
        String delimiterRegex = delimiter.getDelimiterRegex();
        assertEquals("[,:]", delimiterRegex);
    }

    @Test
    void 커스컴_구분자_추가_정규표현식_반환() {
        Delimiter delimiter = new Delimiter();
        delimiter.addDelimiterCharacter(";");
        String delimiterRegex = delimiter.getDelimiterRegex();
        assertEquals("[,:;]", delimiterRegex);
    }

    @Test
    void 불허용_문자_커스텀_구분자_추가_예외_처리() {
        Delimiter delimiter = new Delimiter();
        assertThatThrownBy(() -> {
            delimiter.addDelimiterCharacter("1");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            delimiter.addDelimiterCharacter(",");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            delimiter.addDelimiterCharacter(":");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}