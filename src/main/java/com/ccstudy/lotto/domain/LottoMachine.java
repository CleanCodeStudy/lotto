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

            List<LottoNo> lottoNumbers = getSixLottoNoList(lottoRange.stream()
                    .limit(6)
                    .collect(Collectors.toList()));

            randomLottos.add(new LottoTicket(lottoNumbers));
        }
        return randomLottos;
    }

    public static List<LottoTicket> createManualLottoTickets(List<String> manualNumbers) {
        List<LottoTicket> manualLottos = new ArrayList<>();

        for (String manualNumber : manualNumbers) {

            List<Integer> splits = Arrays.stream(manualNumber.split(SPLITTER))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            List<LottoNo> lottoNumbers = getSixLottoNoList(splits);

            manualLottos.add(new LottoTicket(lottoNumbers));

        }

        return manualLottos;
    }

    public static List<LottoTicket> createFixedLottoTicket(int amountOfFixedLotto) {
        List<LottoTicket> fixedLottos = new ArrayList<>();

        for (int i = 0; i < amountOfFixedLotto; i++) {
            List<Integer> sixList;

            sixList = lottoRange.stream()
                    .skip(i)
                    .limit(6)
                    .collect(Collectors.toList());

            List<LottoNo> lottoNumbers = getSixLottoNoList(sixList);

            fixedLottos.add(new LottoTicket(lottoNumbers));
        }

        return fixedLottos;
    }

    public static List<LottoNo> getSixLottoNoList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new LottoNo(number))
                .collect(Collectors.toList());
    }

}
