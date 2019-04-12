package data;

import view.InputView;

import java.util.List;


public class PurchaseInfo {

    public static final int LOTTO_PRICE = 1000;

    private int purchasePrice;
    private List<String> manualLottos;
    private int autoTicketCount;
    private int manualTicketCount;

    public PurchaseInfo(InputView inputView) {
        this.purchasePrice = inputView.purchase();
        int manualCount = inputView.getManualCount();
        this.manualLottos = inputView.inputManualLotto(manualCount);
        this.autoTicketCount = purchasePrice / LOTTO_PRICE - manualLottos.size();
        this.manualTicketCount = manualCount;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public List<String> getManualLottos() {
        return manualLottos;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

}
