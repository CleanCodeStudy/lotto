package domain;

import util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class LottoList {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MIN_AMOUNT = 0;

    protected List<Lotto> lottos;

    public <T> LottoList(T t) {
        if (t != null)
            this.lottos = buyLotto((Integer) t);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> buyLotto(int price) {
        final int lottoAmount = price / LOTTO_PRICE;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        return IntStream.range(LOTTO_MIN_AMOUNT, lottoAmount)
                .mapToObj(loop -> new Lotto(randomNumberGenerator))
                .collect(Collectors.toList());
    }

    public int getCountByMatchAmount(int match, List<Integer> winningNumber) {
        return (int) this.lottos.stream()
                .filter(lotto -> lotto.isEqual(match, winningNumber))
                .count();
    }

    public void showList() {
        System.out.println(this.lottos.size() + "개를 구매했습니다.");
        String list = lottos.stream()
                .map(Lotto::getListString)
                .collect(Collectors.joining("\n"));
        System.out.println(list);
    }
}
