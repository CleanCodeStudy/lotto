package com.javabom.lotto.domain.vo;

import com.javabom.lotto.domain.WinningSheet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMoneyTest {

    @DisplayName("로또를 1장 이상 구매할 수 없으면 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(ints = {0, 100, 999})
    void cannotBuyLotto(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMoney(purchaseAmount))
                .withMessage("로또를 살 수 없습니다. - " + purchaseAmount);
    }

    @DisplayName("입력받은 금액으로 구매 가능한 로또의 개수를 계산한다.")
    @ParameterizedTest
    @CsvSource({"1000, 1", "2499, 2", "14000, 14"})
    void calculateNumberOfTicket(int purchaseAmount, int expectNumberOfTicket) {
        LottoMoney lottoMoney = new LottoMoney(purchaseAmount);
        assertThat(lottoMoney.getNumberOfAutoTicket()).isEqualTo(expectNumberOfTicket);
    }

    @DisplayName("수동으로 할 티켓의 수가 입력한 금액으로 구매할 수 없으면 IllegalArgumentException throw")
    @ParameterizedTest
    @CsvSource({"1000, 2", "3000, 6"})
    void manualTicketOverPurchaseAmountThrowException(int purchaseAmount, int numberOfManualTicket) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoMoney(purchaseAmount, numberOfManualTicket))
                .withMessage("수동으로 구매할 수 있는 개수를 초과했습니다. - " + numberOfManualTicket);
    }

    @DisplayName("당첨 총액으로 수익률을 계산")
    @Test
    void calculateRateOfReturn() {
        LottoMoney lottoMoney = new LottoMoney(2000);
        int sumOfPrize = WinningSheet.FIFTH.getPrize() + WinningSheet.FOURTH.getPrize();

        double rateOfReturn = lottoMoney.calculateRateOfReturn(sumOfPrize);

        assertThat(rateOfReturn).isEqualTo(sumOfPrize / 2000);
    }
}
