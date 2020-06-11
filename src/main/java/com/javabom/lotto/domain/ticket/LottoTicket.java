package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.number.LottoNumber;
import com.javabom.lotto.domain.number.LottoNumberGenerator;
import com.javabom.lotto.domain.number.NumberGenerator;
import com.javabom.lotto.domain.number.ShuffledNumberGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        validateDuplicateNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket ofFixed(List<Integer> numbers) {
        validateSize(numbers);
        return new LottoTicket(LottoNumberGenerator.generateFixedNumber(numbers));
    }

    public static LottoTicket ofAuto(NumberGenerator numberGenerator) {
        return new LottoTicket(LottoNumberGenerator.generateRandomNumber(LOTTO_NUMBERS_SIZE, numberGenerator));
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다. - " + numbers);
        }
    }

    public boolean isContainingLottoNumbers(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private LottoNumber findByIndex(int index) {
        return lottoNumbers.get(index);
    }

    private static void validateDuplicateNumbers(List<LottoNumber> lottoNumbers) {
        Set<Integer> duplicateNumbers = lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toSet());
        if (duplicateNumbers.size() < LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 될 수 없습니다. - " + lottoNumbers);
        }
    }

    public int findMatchCount(LottoTicket winningTicket) {
        return (int) IntStream.range(0, LOTTO_NUMBERS_SIZE)
                .filter(index -> winningTicket.findByIndex(index).equals(this.findByIndex(index)))
                .count();
    }
}
