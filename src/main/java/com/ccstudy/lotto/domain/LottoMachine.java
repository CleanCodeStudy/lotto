package com.ccstudy.lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final String SPLITTER = ",";
    private static List<Integer> lottoRange = IntStream.range(1, 45)
            .mapToObj(Integer::new)
            .collect(Collectors.toList());

    public static List<LottoTicket> createRandomLottoTickets(int amountOfRandomLotto) {
        List<LottoTicket> randomLottos = new ArrayList<>();

        for (int i = 0; i < amountOfRandomLotto; i++) {
            Collections.shuffle(lottoRange);

            List<LottoNo> lottoNumbers = lottoRange.stream()
                    .limit(6)
                    .map(integer -> new LottoNo(integer))
                    .collect(Collectors.toList());

            randomLottos.add(new LottoTicket(lottoNumbers));
        }
        return randomLottos;
    }

    public static List<LottoTicket> createManualLottoTickets(List<String> manualNumbers) {
        List<LottoTicket> manualLottos = new ArrayList<>();

        for (String manualNumber : manualNumbers) {
            List<LottoNo> lottoNumbers = Arrays.stream(manualNumber.split(SPLITTER))
                    .map(Integer::valueOf)
                    .map(integer -> new LottoNo(integer))
                    .collect(Collectors.toList());

            manualLottos.add(new LottoTicket(lottoNumbers));
        }

        return manualLottos;
    }

    public static List<LottoTicket> createFixedLottoTicket(int amountOfFixedLotto) {
        List<LottoTicket> fixedLottos = new ArrayList<>();

        for (int i = 0; i < amountOfFixedLotto; i++) {
            List<LottoNo> fixedNumbers = lottoRange.stream()
                    .skip(i)
                    .limit(6)
                    .map(integer -> new LottoNo(integer))
                    .collect(Collectors.toList());

            fixedLottos.add(new LottoTicket(fixedNumbers));
        }

        return fixedLottos;
    }
}
