package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.Customer;
import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTicketBundle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoShopTest {

    @DisplayName("구입한 로또 티켓이 잘 들어왔는지 확인한다.")
    @Test
    void buy() {
        List<List<String>> manualLottoNumbers = new ArrayList<>();

        Customer customer = new Customer(1000, manualLottoNumbers);
        LottoShop lottoShop = new LottoShop(new LottoMachine(new FixedNumberGenerator()));
        LottoTicketBundle lottoTicketBundle = lottoShop.buy(customer);

        List<LottoTicket> lottoTickets = lottoTicketBundle.get();
        LottoTicket actual = lottoTickets.get(0);

        assertThat(actual.get(0)).isEqualTo(GameNumber.valueOf(1));
        assertThat(actual.get(1)).isEqualTo(GameNumber.valueOf(2));
        assertThat(actual.get(2)).isEqualTo(GameNumber.valueOf(3));
        assertThat(actual.get(3)).isEqualTo(GameNumber.valueOf(4));
        assertThat(actual.get(4)).isEqualTo(GameNumber.valueOf(5));
        assertThat(actual.get(5)).isEqualTo(GameNumber.valueOf(6));
    }
}
