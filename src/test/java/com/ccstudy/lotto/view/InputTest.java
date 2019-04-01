package com.ccstudy.lotto.view;

import com.ccstudy.lotto.domain.LottoNo;
import com.ccstudy.lotto.domain.LottoTicket;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class InputTest {

    @Test
    public void 만원_입력하면_숫자로_반환() {
        InputStream inputStream = getInputStream("10000");
        int purchase = new Input(inputStream).inputPurchase();

        assertThat(purchase).isEqualTo(10000);
    }

    @Test
    public void inputManualAmountOfLotto() {
        InputStream inputStream = getInputStream("2");
        int manualAmountOfLotto = new Input(inputStream).inputManualAmountOfLotto();

        assertThat(manualAmountOfLotto).isEqualTo(2);
    }

    @Test
    public void inputManualLottoNumber() {
        InputStream inputStream = getInputStream("1, 2, 3, 4, 5, 6");
        List<String> manualLottoNumber = new Input(inputStream).inputManualLottoNumber(1);

        assertThat(manualLottoNumber.get(0)).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    public void inputCorrectAnswer() {
        List<Integer> expectedAnswer = Arrays.asList(1, 2, 3, 4, 5, 10);
        InputStream inputStream = getInputStream("1, 2, 3, 4, 5, 10");

        List<Integer> actualAnswer = new Input(inputStream).inputCorrectAnswer();

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @Test
    public void inputBonusNumber() {
        InputStream inputStream = getInputStream("5");
        int bonusNumber = new Input(inputStream).inputBonusNumber();

        assertThat(bonusNumber).isEqualTo(5);
    }

    public InputStream getInputStream(String inputValue) {
        return new ByteArrayInputStream(inputValue.getBytes());
    }

    public LottoTicket createLottoTicket(List<Integer> numbers) {
        List<LottoNo> lottoNos = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
        return new LottoTicket(lottoNos);
    }
}