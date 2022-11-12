package lotto.enumType;

public enum LottoNumber {

    FIRST_RANGE(1)
    , LAST_RANGE(45)
    , PURCHASE_AMOUNT_COND(1000)
    ;

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
