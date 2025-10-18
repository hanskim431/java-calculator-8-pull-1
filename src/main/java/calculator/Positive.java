package calculator;

public class Positive {
    private final Long number;

    public Positive(Long number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수가 아닌 값이 포함되어 있습니다: " + number);
        }
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }
}

