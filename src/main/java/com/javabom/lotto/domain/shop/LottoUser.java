package com.javabom.lotto.domain.shop;

import com.javabom.lotto.domain.dto.ManualLottoCountDto;
import com.javabom.lotto.domain.dto.ManualLottoNumbersDto;
import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.vo.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoUser {

    private Money money;

    private int manualLottoCount;

    public LottoUser(Money money, ManualLottoCountDto manualLottoCountDto) {
        this.money = money;
        this.manualLottoCount = manualLottoCountDto.getLottoCount();
        validManualLottoCount();
    }

    private void validManualLottoCount() {
        int manualLottoCountPrice = manualLottoCount * LottoShop.TICKET_PRICE;
        if (!money.canSpendMoney(manualLottoCountPrice)) {
            throw new IllegalArgumentException("로또를 구매할 돈이 부족합니다.");
        }
    }

    private void buyTicket() {
        money.spendMoney(LottoShop.TICKET_PRICE);
    }

    private boolean canBuyTicket() {
        return money.canSpendMoney(LottoShop.TICKET_PRICE);
    }

    public LottoTickets buyTicketsByAutomaticInLottoShop(LottoShop lottoShop) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (canBuyTicket()) {
            lottoTickets.add(lottoShop.generateTicket());
            buyTicket();
        }
        return new LottoTickets(lottoTickets);
    }

    public LottoTickets buyTicketsByManualInLottoShop(LottoShop lottoShop, ManualLottoNumbersDto manualLottoNumbersDto) {
        List<LottoTicket> manualTickets = new ArrayList<>();
        List<Set<LottoNumber>> lottoNumbers = manualLottoNumbersDto.getManualLottoNumbers();
        for (Set<LottoNumber> lottoNumber : lottoNumbers) {
            manualTickets.add(lottoShop.giveLottoTicket(lottoNumber));
            buyTicket();
        }
        return new LottoTickets(manualTickets);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    public Money getMoney() {
        return money;
    }

}

