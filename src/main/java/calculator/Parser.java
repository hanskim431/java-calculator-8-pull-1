package calculator;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public Parser(String inputText, List<Positive> positives, Delimiter delimiter) {
        validateParameters(inputText, positives, delimiter);
        parseInputText(inputText, positives, delimiter);
    }

    private void validateParameters(String inputText, List<Positive> positives, Delimiter delimiter) {
        if (inputText == null) {
            throw new IllegalArgumentException("입력 문자열은 null일 수 없습니다.");
        }
        if (positives == null) {
            throw new IllegalArgumentException("결과 리스트는 null일 수 없습니다.");
        }
        if (delimiter == null) {
            throw new IllegalArgumentException("구분자는 null일 수 없습니다.");
        }
    }

    private void parseInputText(String inputText, List<Positive> positives, Delimiter delimiter) {
        if (inputText.length() == 0) {
            return;
        }

        // 커스텀 구분자 확인 기능
        inputText = checkCustomDelimiter(inputText, delimiter);

        String regex = delimiter.getDelimiterRegex();
        String[] split = inputText.split(regex);
        Arrays.stream(split).map(this::parseLong).map(Positive::new).forEach(positives::add);
    }

    private Long parseLong(String string) {
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + string);
        }
    }

    private String checkCustomDelimiter(String inputText, Delimiter delimiter) {
        if (!inputText.startsWith("//")) {
            return inputText;
        }

        if (!inputText.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 추가 구문이 올바르지 않습니다: " + inputText);
        }

        String[] split = inputText.split("\\\\n");

        if (split[0].length() != 3) {
            throw new IllegalArgumentException("커스텀 구분자의 길이 제한은 1입니다:" + split[0]);
        }

        String newDelimiter = split[0].substring(2, 3);
        delimiter.addDelimiterCharacter(newDelimiter);

        if (split.length > 2) {
            throw new IllegalArgumentException("커스텀 구분자 추가 구문이 올바르지 않습니다: " + inputText);
        }

        return split[1];
    }
}
