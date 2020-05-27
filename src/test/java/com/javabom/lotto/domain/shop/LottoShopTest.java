package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.info.LottoBundle;
import com.javabom.lotto.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoShopTest {

    @DisplayName("로또를 구입했을 때 구입 금액에 맞는 로또 크기를 반환하는지 확인한다.")
    @ParameterizedTest
    @CsvSource({"2000,2", "10000,10"})
    void buyLotto(String strMoney, int expected) {
        LottoShop lottoShop = new LottoShop(new RandomMachine(new FixedGenerateLottoNumber()));
        Money money = new Money(strMoney);
        LottoBundle lottoBundle = lottoShop.buyLotto(money);
        assertThat(lottoBundle.getMyLottoBundle().size()).isEqualTo(expected);
    }

    @DisplayName("금액이 1000원 이상 들어오지 않았을 시 IllegalArgumentException 을 발생시킨다.")
    @Test
    void checkCanBuyLotto() {
        LottoShop lottoShop = new LottoShop(new RandomMachine(new FixedGenerateLottoNumber()));
        Money money = new Money("900");
        assertThatThrownBy(() -> lottoShop.buyLotto(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈이 부족합니다. 1000원 이상 금액을 입력해 주세요.");
    }

    @DisplayName("금액이 1000원 이상 들어왔을 때 살 수 있는 로또 갯수를 반환한다.")
    @ParameterizedTest
    @CsvSource({"1000,1", "14000, 14"})
    void getLottoCount(String strMoney, int expected) {
        LottoShop lottoShop = new LottoShop(new RandomMachine(new FixedGenerateLottoNumber()));
        Money money = new Money(strMoney);
        assertThat(lottoShop.getLottoCount(money.get())).isEqualTo(expected);
    }
}