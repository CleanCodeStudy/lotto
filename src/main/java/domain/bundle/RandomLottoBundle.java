package domain.bundle;

import domain.LottoTicket;
import util.numberGenerator.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoBundle extends LottoBundle {

    public RandomLottoBundle(int price) {
        super.lottoTickets = buyLotto(price);
    }

    @Override
    protected List<LottoTicket> buyLotto(int price) {
        final int lottoAmount = price / LOTTO_PRICE;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        return IntStream.range(LOTTO_MIN_AMOUNT, lottoAmount)
                .mapToObj(loop -> new LottoTicket(randomNumberGenerator))
                .collect(Collectors.toList());
    }

}

