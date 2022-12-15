package lotto.domain;

import lotto.util.InputUtil;
import lotto.util.MessageUtil;
import lotto.util.ValidationUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constant.message.InputMessage.BONUS;
import static lotto.constant.message.InputMessage.WINNING;

public class LottoWinningNumber {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final ValidationUtil validationUtil = new ValidationUtil();

    private List<Integer> winningNums;

    private Integer bonusNum;

    public LottoWinningNumber getWinningNumbersInfo() {
        this.winningNums = getWinningNumbers();
        this.bonusNum = getBonusNumbers();

        return this;
    }

    public List<Integer> getWinningNums() {
        return winningNums;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }

    private List<Integer> getWinningNumbers() {
        outputView.printMessage(WINNING.getValue());
        String winningNums = inputView.getUserInput();
        String[] winningAmount = validationUtil.validateWinningAmount(winningNums);

        return Arrays.stream(winningAmount)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getBonusNumbers() {
        outputView.printMessage(BONUS.getValue());
        int bonusNum = Integer.parseInt(inputView.getUserInput());
        validationUtil.validateBonusRange(bonusNum);

        return bonusNum;
    }
}
