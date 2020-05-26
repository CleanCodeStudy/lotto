package com.javabom.lotto.domain;

import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.vo.Money;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @DisplayName("금액을 입력하면 구매한 로또티켓을 반환한다")
    @Test
    void buyTest() {
        LottoStore lottoStore = new LottoStore(new AutoLottoNumberGenerator());

        LottoTickets lottoTickets = lottoStore.buy(new Money(14000));

        AssertionsForClassTypes.assertThat(lottoTickets.count()).isEqualTo(14);
    }

}
