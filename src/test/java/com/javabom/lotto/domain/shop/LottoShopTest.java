package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    @Test
    @DisplayName("입력한 금액만큼 로또 티켓을 반환하는지 확인.")
    void buyTicketsByAutomaticInLottoShop() {
        Money money = new Money(5000);
        LottoShop lottoShop = new LottoShop(new LottoNumbersGenerator());

        LottoTickets lottoTickets = lottoShop.buyTicketsByAutomaticInLottoShop(money);

        assertEquals(5, lottoTickets.size());
    }

    @Test
    @DisplayName("입력한 로또 수동번호 만큼 로또 티켓을 반환하는지 확인.")
    void buyTicketsByManualInLottoShop() {
        List<List<LottoNumber>> manualNumbers = createLottoNumbers();
        LottoShop lottoShop = new LottoShop(new LottoNumbersGenerator());

        LottoTickets lottoTickets = lottoShop.buyTicketsByManualInLottoShop(manualNumbers);

        assertEquals(2, lottoTickets.size());
    }

    private List<List<LottoNumber>> createLottoNumbers() {
        List<List<LottoNumber>> lottoNumbers = new ArrayList<>();
        List<LottoNumber> numbers1 = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        List<LottoNumber> numbers2 = Stream.of(7, 8, 9, 10, 11, 12)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        lottoNumbers.add(numbers1);
        lottoNumbers.add(numbers2);
        return lottoNumbers;
    }

    @Test
    @DisplayName("입력한 금액에서 구매한 티켓 금액만큼 차감 후 잔액을 반환하는지 확인.")
    void getRemainMoney() {
        LottoShop lottoShop = new LottoShop(new LottoNumbersGenerator());
        LottoTickets lottoTickets = getLottoTickets();
        Money money = new Money(5000);
        Money remainMoney = lottoShop.getRemainMoney(lottoTickets, money);
        assertEquals(3000, remainMoney.getValue());
    }

    private LottoTickets getLottoTickets() {
        List<List<LottoNumber>> lottoNumbers = createLottoNumbers();
        List<LottoTicket> lottoTickets = new ArrayList<>();
        LottoTicket lottoTicket1 = new LottoTicket(lottoNumbers.get(0));
        LottoTicket lottoTicket2 = new LottoTicket(lottoNumbers.get(1));
        lottoTickets.add(lottoTicket1);
        lottoTickets.add(lottoTicket2);

        return new LottoTickets(lottoTickets);
    }
}