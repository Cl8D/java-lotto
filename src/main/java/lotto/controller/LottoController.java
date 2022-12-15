package lotto.controller;

import lotto.domain.LottoPrize;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoWinningNumber;
import lotto.view.OutputView;

import static lotto.constant.message.InputMessage.PURCHASE;

public class LottoController {

    private final OutputView outputView = new OutputView();

    private final LottoPurchase lottoPurchase = new LottoPurchase();

    private final LottoWinningNumber lottoWinningNumber = new LottoWinningNumber();

    private final PurchaseController purchaseController = new PurchaseController();

    public void process() {
        outputView.printMessage(PURCHASE.getValue());
        try {
            purchaseController.buyLotto();
            LottoPurchase purchaseInfo = lottoPurchase.getPurchaseInfo();
            LottoWinningNumber winningNumbersInfo = lottoWinningNumber.getWinningNumbersInfo();
            LottoPrize lottoPrize = new LottoPrize(winningNumbersInfo);
            lottoPrize.getLottoStats(purchaseInfo.getUserLottos(), purchaseInfo.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

