package dto;

import domain.LottoGame;

import java.util.List;

public class PurchaseInfoDto {
    private int money;
    private int amount;
    private List<String> manualLottos;

    public PurchaseInfoDto(int money, int amount, List<String> numbers) {
        this.money = money;
        this.amount = amount;
        this.manualLottos = numbers;
    }

    private void validateInfo() {
        if (money < amount || amount != manualLottos.size()) {
            throw new IllegalArgumentException();
        }
    }

    public LottoGame buyLotto() {
        validateInfo();
        return new LottoGame(money, manualLottos);
    }
}
