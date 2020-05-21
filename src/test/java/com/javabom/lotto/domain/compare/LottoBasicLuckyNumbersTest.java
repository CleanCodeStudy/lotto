package com.javabom.lotto.domain.compare;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoBasicLuckyNumbersTest {

    @DisplayName("기본 당첨 번호의 개수는 6개이여야 함.")
    @CsvSource({"5", "7"})
    @ParameterizedTest
    void validateLottoNumbersSize(int size) {
        // given
        List<LottoNumber> lottoNumbers = stubLottoNumbers(size);

        // then
        assertThatThrownBy(() -> new LottoBasicLuckyNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 반드시 6개입니다.");
    }

    private List<LottoNumber> stubLottoNumbers(int size) {
        ArrayList<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(new LottoNumber(size));
        }
        return numbers;
    }
}