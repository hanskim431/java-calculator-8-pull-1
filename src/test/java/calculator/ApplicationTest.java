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

    @Test
    void 입력_안내_문구_출력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("덧셈할 문자열을 입력해 주세요.");
        });
    }

    @Test
    void 계산_결과_안내_문구_출력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 :");
        });
    }

    @Test
    void 빈_문자열_계산_결과_출력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 단일_숫자_입력_결과_출력() {
        assertSimpleTest(() -> {
            run("1\n");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 기본_구분자_포함_여러_숫자_입력_결과_출력() {
        assertSimpleTest(() -> {
            run("1,2,3:4\n");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 양수_입력_검증_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 잘못된_구분자_입력_예외_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2!3;4:5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자_연속_입력_예외_검증() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,5"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_구분자_사용_단일_숫자_결과_출력() {
        assertSimpleTest(() -> {
            run("//!\\n1\n");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 커스텀_구분자_사용_여러_숫자_결과_출력() {
        assertSimpleTest(() -> {
            run("//!\\n1!2!3\n");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 기본_커스텀_구분자_복합_사용_여러_숫자_결과_출력() {
        assertSimpleTest(() -> {
            run("//!\\n1,2:3!4\n");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 기본_구문자를_커스텀_구분자_추가_시도_예외_처리() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//,\\n")).isInstanceOf(IllegalArgumentException.class);
        });
    }
    @Test
    void 숫자를_커스텀_구분자_추가_시도_예외_처리() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("//4\\n")).isInstanceOf(IllegalArgumentException.class);
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
