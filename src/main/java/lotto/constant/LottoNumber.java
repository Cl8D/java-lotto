package lotto.constant;

import lotto.util.EnumUtil;

public enum LottoNumber implements EnumUtil<Integer> {

    FIRST_RANGE(1)
    , LAST_RANGE(45)
    , MAX_COUNT(6)
    , PURCHASE_AMOUNT_COND(1000)
    ;

    private final int number;

    LottoNumber(int number) {
        this.number = number;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public Integer getValue() {
        return number;
    }
}
