package domain.factory;

import domain.LottoNumber;
import domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGroup {
    private static final int LOTTO_LIMIT = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_PRICE = 1_000;
    private final List<LottoNumber> lottoNumbers = initLottoNumber();

    public List<Integer> createLottos(int price) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        int lottoAmount = price/LOTTO_PRICE;

        for (int i = 0; i < lottoAmount; i++) {
                lottoTickets.add(new LottoTicket(pickLottoNumbers()));
        }
        return lottoTickets;
    }

    private List<LottoNumber> pickLottoNumbers(){
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(LOTTO_LIMIT)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<LottoNumber> initLottoNumber() {
        return IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
