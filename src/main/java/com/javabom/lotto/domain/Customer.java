package com.javabom.lotto.domain;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.ticket.LottoTicketBundle;
import com.javabom.lotto.domain.number.PrizeNumbersBundle;
import com.javabom.lotto.domain.result.LottoResultBundle;
import com.javabom.lotto.domain.number.GameNumber;
import com.javabom.lotto.domain.utils.GameNumberConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final int amount;
    private final List<List<GameNumber>> manualLottoNumbers;
    private LottoTicketBundle lottoTicketBundle;

    public Customer(int amount, List<List<String>> strManualLottoNumbers) {
        checkPositive(amount);
        checkBuyManualLottoTicket(amount, strManualLottoNumbers.size());
        this.amount = amount;
        this.manualLottoNumbers = collet(strManualLottoNumbers);
        this.lottoTicketBundle = null;
    }

    private void checkPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(String.format("%d, 0원 이상의 돈을 입력해 주세요.", amount));
        }
    }

    private void checkBuyManualLottoTicket(int amount, int ticketCount) {
        int requiredAmount = ticketCount * LottoTicket.PRICE;
        if (amount < requiredAmount) {
            throw new IllegalArgumentException(String.format("현재 보유 금액:%d, 필요한 금액:%d, 금액이 부족합니다.", amount, requiredAmount));
        }
    }

    private List<List<GameNumber>> collet(List<List<String>> strManualLottoNumbers) {
        List<List<GameNumber>> manualLottoNumbers = new ArrayList<>();
        for (List<String> eachManualLottoNumbers : strManualLottoNumbers) {
            manualLottoNumbers.add(GameNumberConverter.convert(eachManualLottoNumbers));
        }
        return manualLottoNumbers;
    }

    public List<List<GameNumber>> getManualLottoNumbers() {
        return Collections.unmodifiableList(manualLottoNumbers);
    }

    public int getAutoLottoTicketCount() {
        int curAmount = amount - (manualLottoNumbers.size() * LottoTicket.PRICE);
        if (curAmount < LottoTicket.PRICE) {
            return 0;
        }
        return curAmount / LottoTicket.PRICE;
    }

    public void buy(List<LottoTicket> lottoTickets) {
        if (lottoTicketBundle != null) {
            lottoTicketBundle.addLottoTickets(lottoTickets);
        }
        lottoTicketBundle = new LottoTicketBundle(lottoTickets);
    }

    public LottoTicketBundle getLottoTicketBundle() {
        return new LottoTicketBundle(lottoTicketBundle.get());
    }

    public LottoResultBundle confirmLottoResult(PrizeNumbersBundle prizeNumberBundle) {
        return lottoTicketBundle.match(prizeNumberBundle);
    }
}
