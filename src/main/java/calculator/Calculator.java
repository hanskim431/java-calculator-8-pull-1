package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private Long result;
    private List<Positive> positives;
    private Delimiter delimiter;

    public Calculator(String inputText) {
        validateInputText(inputText);
        this.result = 0L;
        positives = new ArrayList<>();
        delimiter = new Delimiter();
        new Parser(inputText, positives, delimiter);
        sumPositives();
    }

    private void validateInputText(String inputText) {
        if (inputText == null) {
            throw new IllegalArgumentException("입력 문자열은 null일 수 없습니다.");
        }
    }

    private void addPositive(Positive positive) {
        result += positive.getNumber();
    }

    private void sumPositives() {
        positives.forEach(this::addPositive);
    }

    public Long getResult() {
        return result;
    }
}
