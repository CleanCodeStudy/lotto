package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.number.OrderGameNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.utils.GameNumberConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @DisplayName("수동 로또 번호 값이 잘 들어왔는지 확인한다.")
    @Test
    void createManualLottoTicket() {
        List<String> strGameNumbers = (Arrays.asList("1", "2", "3", "4", "5", "6"));
        List<OrderGameNumber> gameNumbers = GameNumberConverter.convert(strGameNumbers);

        List<List<OrderGameNumber>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(gameNumbers);

        LottoMachine lottoMachine = new LottoMachine(new AutoLottoNumberGenerator());
        List<LottoTicket> lottoTickets = lottoMachine.createManualLottoTicket(manualLottoNumbers);
        LottoTicket actual = lottoTickets.get(0);

        assertThat(actual.get(0)).isEqualTo(GameNumber.valueOf(1));
        assertThat(actual.get(1)).isEqualTo(GameNumber.valueOf(2));
        assertThat(actual.get(2)).isEqualTo(GameNumber.valueOf(3));
        assertThat(actual.get(3)).isEqualTo(GameNumber.valueOf(4));
        assertThat(actual.get(4)).isEqualTo(GameNumber.valueOf(5));
        assertThat(actual.get(5)).isEqualTo(GameNumber.valueOf(6));
    }

    @DisplayName("랜덤 로또 번호 값이 잘 들어왔는지 확인한다.")
    @Test
    void createAutoLottoTicket() {
        LottoMachine lottoMachine = new LottoMachine(new FixedNumberGenerator());
        List<LottoTicket>lottoTickets = lottoMachine.createAutoLottoTicket(1);
        LottoTicket actual = lottoTickets.get(0);

        assertThat(actual.get(0)).isEqualTo(GameNumber.valueOf(1));
        assertThat(actual.get(1)).isEqualTo(GameNumber.valueOf(2));
        assertThat(actual.get(2)).isEqualTo(GameNumber.valueOf(3));
        assertThat(actual.get(3)).isEqualTo(GameNumber.valueOf(4));
        assertThat(actual.get(4)).isEqualTo(GameNumber.valueOf(5));
        assertThat(actual.get(5)).isEqualTo(GameNumber.valueOf(6));
    }
}
