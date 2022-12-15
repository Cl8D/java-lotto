package lotto.constant.message;

import lotto.util.EnumUtil;

public enum InputMessage implements EnumUtil<String> {

    PURCHASE("구입금액을 입력해 주세요.")
    , WINNING("당첨 번호를 입력해 주세요.")
    , BONUS("보너스 번호를 입력해 주세요.")
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
