package domain;

public class LottoNo {
    private static int MIN_BOUNDARY = 1;
    private static int MAX_BOUNDARY = 45;

    private Integer number;

    public LottoNo(int number) {
        isCorrect(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private boolean isCorrect(int number) {
        if (number < MIN_BOUNDARY || number > MAX_BOUNDARY) {
            throw new RuntimeException();
        }
        return true;
    }
}

