package com.javabom.lotto.domain;

import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.number.OrderGameNumber;
import com.javabom.lotto.domain.utils.GameNumberConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private final int amount;
    private final List<List<OrderGameNumber>> manualLottoNumbers;

    public Customer(int amount, List<List<String>> strManualLottoNumbers) {
        checkPositive(amount);
        checkBuyManualLottoTicket(amount, strManualLottoNumbers.size());
        this.amount = amount;
        this.manualLottoNumbers = collet(strManualLottoNumbers);
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

    private List<List<OrderGameNumber>> collet(List<List<String>> strManualLottoNumbers) {
        List<List<OrderGameNumber>> manualLottoNumbers = new ArrayList<>();
        for (List<String> eachManualLottoNumbers : strManualLottoNumbers) {
            checkCount(eachManualLottoNumbers.size());

            List<OrderGameNumber> orderGameNumbers = GameNumberConverter.convert(eachManualLottoNumbers);
            checkDuplicate(orderGameNumbers.size());

            manualLottoNumbers.add(GameNumberConverter.convert(eachManualLottoNumbers));

        }
        return manualLottoNumbers;
    }

    private void checkCount(int numberCount) {
        if (numberCount != LottoTicket.COUNT) {
            throw new IllegalArgumentException(String.format("%d개의 수동 로또 번호를 입력하셨습니다. 수동 로또 번호는 총 6개여야 합니다.", numberCount));
        }
    }

    private void checkDuplicate(int gameNumbersSize) {
        if (gameNumbersSize != LottoTicket.COUNT) {
            throw new IllegalArgumentException("수동 로또 번호는 모두 달라야 합니다.");
        }
    }

    public int getAutoLottoTicketCount() {
        int curAmount = amount - (manualLottoNumbers.size() * LottoTicket.PRICE);
        if (curAmount < LottoTicket.PRICE) {
            return 0;
        }
        return curAmount / LottoTicket.PRICE;
    }

    public List<List<OrderGameNumber>> getManualLottoNumbers() {
        return Collections.unmodifiableList(this.manualLottoNumbers);
    }
}
