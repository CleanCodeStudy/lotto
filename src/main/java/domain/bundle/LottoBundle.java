package domain.bundle;

import domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public abstract class LottoBundle {
    protected static final int LOTTO_PRICE = 1000;
    protected static final int LOTTO_MIN_AMOUNT = 0;

    protected List<LottoTicket> lottoTickets;

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    protected abstract List<LottoTicket> buyLotto(int price);

    public int getCountOfMatch(int match, List<Integer> winningNumber) {
        return (int) this.lottoTickets.stream()
                .filter(lotto -> lotto.checkRank(match, winningNumber))
                .count();
    }

    public void showList() {
        System.out.println(this.lottoTickets.size() + "개를 구매했습니다.");
        String list = lottoTickets.stream()
                .map(LottoTicket::getListString)
                .collect(Collectors.joining("\n"));
        System.out.println(list);
    }
}
