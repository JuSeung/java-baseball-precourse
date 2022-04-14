package baseball.env;


public enum RestrictionsNumber {
    SIZE_LIMIT_NUMBER(3),
    START_NUMBER(1),
    END_NUMBER(9);

    private int number;

    RestrictionsNumber(int value) {
        this.number = value;
    }

    public int getNumber() {
        return number;
    }
}



