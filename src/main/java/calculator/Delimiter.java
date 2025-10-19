package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {
    List<Character> delimiterCharacters;

    public Delimiter() {
        List<Character> delimiterCharacters = new ArrayList<>(Arrays.asList(',', ':'));
        this.delimiterCharacters = delimiterCharacters;
    }

    public String getDelimiterRegex() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        delimiterCharacters.stream().forEach(stringBuilder::append);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void addDelimiterCharacter(String newDelimiter) {
        if (newDelimiter == null) {
            throw new IllegalArgumentException("null은 커스텀 구분자로 추가할 수 없습니다.");
        }

        if (newDelimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 필수 길이는 1입니다");
        }

        if (",".equals(newDelimiter) || ":".equals(newDelimiter)) {
            throw new IllegalArgumentException("기본 구분자를 커스텀 구분자로 추가할 수 없습니다.");
        }
        
        if (newDelimiter.charAt(0) >= '0' && newDelimiter.charAt(0) <= '9') {
            throw new IllegalArgumentException("숫자를 커스텀 구분자로 추가할 수 없습니다.");
        }
        
        this.delimiterCharacters.add(newDelimiter.charAt(0));
    }
}
