package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PositiveTest {

    @Test
    void 음수_입력시_예외_반환() {
        //Given
        //When
        //That
        assertThatThrownBy(() -> {
            new Positive(-1L);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}