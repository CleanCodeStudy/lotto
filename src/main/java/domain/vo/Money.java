package domain.vo;

import domain.LottoTicket;

public class Money {
    private final Long money;

    public Money(Long money) {
        validateMoney(money);
        this.money = money;
    }

    public Long getMoney() {
        return money;
    }

    public long getAmountOfLotto() {
        return money / LottoTicket.LOTTO_PRICE;
    }

    public void validateMoney(Long money){
        if(money < 0){
            throw new IllegalArgumentException();
        }
    }

    public static Money getInvestment(int count){
        return new Money((long) count * LottoTicket.LOTTO_PRICE);
    }

    public double calculate(Money money) {
        return  (this.money - money.getMoney()) / money.getMoney() * 100;
    }
}
