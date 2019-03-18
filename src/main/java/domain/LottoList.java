package domain;

import util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoList {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private List<Lotto> lottos;

    public List<Lotto> getLottos() {
        return lottos;
    }

    protected void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoList(int price) {
        this.lottos = buyLotto(price);
    }

    private List<Lotto> buyLotto(int price) {
        final int lottoAmount = price / LOTTO_PRICE;
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        return IntStream.range(ZERO, lottoAmount)
                .mapToObj(loop -> new Lotto(randomNumberGenerator))
                .collect(Collectors.toList());
    }

    public int findListSizeByMatchAmount(int match, List<Integer> winningNumber) {
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

