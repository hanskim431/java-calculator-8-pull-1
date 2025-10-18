package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Parser {
    public Parser(String inputText, List<Positive> positives, Delimiter delimiter) {
        parseInputText(inputText, positives, delimiter);
    }

    private void parseInputText(String inputText, List<Positive> positives, Delimiter delimiter) {
        if (inputText.length() == 0) {
            return;
        }
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
}
