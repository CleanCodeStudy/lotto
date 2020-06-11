package com.javabom.lotto.dto;

import com.javabom.lotto.domain.shop.LottoNumbersGenerator;
import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersDto {

    private final List<LottoNumber> winningNumbers;

    private final LottoNumber bonusNumber;

    public WinningNumbersDto(List<String> numbers, String bonusNumber) {
        validNumberFormat(bonusNumber);
        this.bonusNumber = new LottoNumber(Integer.parseInt(bonusNumber));
        this.winningNumbers = LottoNumbersGenerator.convertToLottoNumbers(parseIntNumbers(numbers));
        LottoTicket.validNumbers(this.winningNumbers);
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
            throw new NumberFormatException(String.format("정수가 아닌 값이 입력 되었습니다. - %s", number));
        }
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
