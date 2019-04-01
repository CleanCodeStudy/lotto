package com.ccstudy.lotto.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 랜덤_로또_생성_테스트() {
        LottoTicket randomLotto = LottoMachine.createRandomLottoTickets(1).get(0);

        int max = randomLotto.getLottoNumber().stream()
                .max(Comparator.comparingInt(Integer::byteValue))
                .get();

        int min = randomLotto.getLottoNumber().stream()
                .min(Comparator.comparingInt(Integer::byteValue))
                .get();

        assertThat(max).isLessThanOrEqualTo(45);
        assertThat(min).isGreaterThanOrEqualTo(1);
    }

    @Test
    public void 수동_로또_생성_테스트() {
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,3,5,6,7,9");
        LottoTicket manualLotto = LottoMachine.createManualLottoTickets(manualNumbers).get(0);

        assertThat(manualLotto.getLottoNumber()).contains(1, 3, 5, 6, 7, 9);
    }

    @Test
    public void 고정된_숫자_생성_테스트() {
        List<LottoTicket> fixedLottos = LottoMachine.createFixedLottoTicket(1);

        LottoTicket fixedLotto = fixedLottos.get(0);

        assertThat(fixedLotto.getLottoNumber()).contains(1, 2, 3, 4, 5, 6);
    }
}