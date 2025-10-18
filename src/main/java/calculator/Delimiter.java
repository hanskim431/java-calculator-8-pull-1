package calculator;

import java.util.Arrays;
import java.util.List;

public class Delimiter {
    List<Character> delimiterCharacters;

    public Delimiter() {
        List<Character> delimiterCharacters = Arrays.stream(new Character[]{',', ':'}).toList();
        this.delimiterCharacters = delimiterCharacters;
    }

    public String getDelimiterRegex() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        delimiterCharacters.stream().forEach(stringBuilder::append);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
