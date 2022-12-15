package lotto.domain;

import lotto.constant.LottoNumber;
import lotto.service.PurchaseService;
import lotto.util.MessageUtil;
import lotto.util.NumberUtil;
import lotto.util.ValidationUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.message.OutputMessage.PURCHASE_COUNT;

public class LottoPurchase {

    private final PurchaseService purchaseService = new PurchaseService();

    private final MessageUtil messageUtil = new MessageUtil();


    private final NumberUtil numberUtil = new NumberUtil();

    private List<Lotto> userLottos;

    private int purchaseAmount;

    private final OutputView outputView = new OutputView();

    public LottoPurchase getPurchaseInfo() {
        int purchaseAmount = purchaseService.getUserPurchaseAmount();
        List<Lotto> userLottos = new ArrayList<>();
        int purchaseCount = getPurchaseCount(purchaseAmount);

        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = generateLottoNumbers();
            userLottos.add(lotto);
        }

        this.userLottos = userLottos;
        this.purchaseAmount = purchaseAmount;

        return this;
    }



    private int getPurchaseCount(int purchaseAmount) {
        int purchaseCount = purchaseAmount / LottoNumber.PURCHASE_AMOUNT_COND.getValue();
        outputView.printParamMessage(PURCHASE_COUNT.getValue(), purchaseCount);

        return purchaseCount;
    }

    private Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = numberUtil.getLottoNumbers();
        Lotto lotto = new Lotto(lottoNumbers);
        messageUtil.printPurchaseInfo(lotto.getLottoNumbers());

        return lotto;
    }

    public List<Lotto> getUserLottos() {
        return userLottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
