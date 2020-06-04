package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.dto.ManualLottoCountDto;
import com.javabom.lotto.domain.dto.ManualLottoNumbersDto;
import com.javabom.lotto.domain.dto.MoneyDto;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoUserTest {


    @Test
    @DisplayName("수동으로 구매할 로또 티켓 개수만큼 금액이 부족하면 예외처리.")
    public void validManualCountByMoneyTest() {
        assertThatThrownBy(() -> {
            Money money = new Money(new MoneyDto("1000"));
            new LottoUser(money, new ManualLottoCountDto("2"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 구매할 돈이 부족합니다.");
    }

    @Test
    @DisplayName("보유한 금액만큼 자동으로 로또 티켓을 구하는지 확인")
    void buyTicketsByAutomaticInLottoShop() {
        Money money = new Money(new MoneyDto("5000"));
        LottoUser lottoUser = new LottoUser(money, new ManualLottoCountDto("0"));
        LottoShop lottoShop = new LottoShop(new LottoNumberShuffler());
        LottoTickets lottoTickets = lottoUser.buyTicketsByAutomaticInLottoShop(lottoShop);

        assertEquals(5, lottoTickets.size());
    }

    @Test
    @DisplayName("수동으로 입력한 로또 티켓 개수 만큼 로또 티겟을 구매하는지 확인")
    void buyTicketsByManualInLottoShop() {
        Money money = new Money(new MoneyDto("3000"));
        LottoUser lottoUser = new LottoUser(money, new ManualLottoCountDto("3"));
        LottoShop lottoShop = new LottoShop(new LottoNumberShuffler());
        ManualLottoNumbersDto manualLottoNumbersDto = createManualLottoNumbersDto();
        LottoTickets lottoTickets = lottoUser.buyTicketsByManualInLottoShop(lottoShop, manualLottoNumbersDto);

        assertEquals(3, lottoTickets.size());
    }

    ManualLottoNumbersDto createManualLottoNumbersDto() {
        List<String> lottoNumbers = new ArrayList<>();
        lottoNumbers.add("1,2,3,4,5,6");
        lottoNumbers.add("1,2,3,4,5,7");
        lottoNumbers.add("1,2,3,4,5,7");
        return new ManualLottoNumbersDto(lottoNumbers);
    }
}