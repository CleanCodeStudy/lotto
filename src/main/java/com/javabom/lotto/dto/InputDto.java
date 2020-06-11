package com.javabom.lotto.dto;

import com.javabom.lotto.domain.shop.LottoNumbersGenerator;
import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import com.javabom.lotto.domain.vo.Money;

import java.util.List;
import java.util.stream.Collectors;

public class InputDto {

    private Money money;

    private int manualCount;

    private List<List<LottoNumber>> manualNumbers;

    public InputDto(String money, String manualCount) {
        validInputValue(money, manualCount);
        this.money = new Money(Integer.parseInt(money));
        this.manualCount = Integer.parseInt(manualCount);
        validMoney();
    }

    private void validMoney() {
        int ticketPrice = manualCount * LottoShop.TICKET_PRICE.getValue();
        int inputMoney = money.getValue();
        if (ticketPrice > inputMoney || !money.canSpendMoney(LottoShop.TICKET_PRICE)) {
            throw new IllegalArgumentException(
                    String.format("로또를 구매할 금액이 부족합니다. - Money : %d, Ticket Price : %d", inputMoney, ticketPrice));
        }
    }

    private void validInputValue(String money, String manualCount) {
        validNumberFormat(money);
        validNegativeNumber(money);
        validNumberFormat(manualCount);
        validNegativeNumber(manualCount);
    }

    private void validNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException(String.format("양수 값을 입력 해주세요. - %s", number));
        }
    }

    public void setManualNumbers(List<List<String>> manualNumbers) {
        this.manualNumbers = convertLottoNumbers(manualNumbers);
    }

    private List<List<LottoNumber>> convertLottoNumbers(List<List<String>> manualNumbers) {
        return manualNumbers.stream()
                .map(this::parseIntNumbers)
                .map(LottoNumbersGenerator::convertToLottoNumbers)
                .peek(LottoTicket::validNumbers)
                .collect(Collectors.toList());
    }

    private List<Integer> parseIntNumbers(List<String> numbers) {
        return numbers.stream()
                .map(number -> {
                    validNumberFormat(number);
                    return Integer.parseInt(number);
                })
                .collect(Collectors.toList());
    }

    private void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("숫자 값을 입력해주세요. - %s", number));
        }
    }


    public List<List<LottoNumber>> getManualNumbers() {
        return manualNumbers;
    }

    public int getManualCount() {
        return manualCount;
    }

    public Money getMoney() {
        return money;
    }
}
