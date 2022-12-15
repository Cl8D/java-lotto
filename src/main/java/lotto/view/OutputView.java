package lotto.view;

import static lotto.constant.message.OutputMessage.PURCHASE_COUNT;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printParamMessage(String message, int param) {
        System.out.printf(message, param);
    }

}
