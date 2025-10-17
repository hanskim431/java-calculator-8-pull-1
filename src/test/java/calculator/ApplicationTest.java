package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
//    @Test
//    void 커스텀_구분자_사용() {
//        assertSimpleTest(() -> {
//            run("//;\\n1");
//            assertThat(output()).contains("결과 : 1");
//        });
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() ->
//            assertThatThrownBy(() -> runException("-1,2,3"))
//                .isInstanceOf(IllegalArgumentException.class)
//        );
//    }

    @Test
    void 입력_안내_문구_출력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
