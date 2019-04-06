package util;

import domain.LottoTicket;
import domain.WinningLotto;

import java.util.Arrays;

public enum PrizeGroup {

    FIRST(6, 2000000000, "6개 일치 (2000000000원)"),
    SECOND(5, 30000000, "6개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(5, 1500000, "5개 일치 (150000원)"),
    FOURTH(4, 50000, "4개 일치 (50000원)"),
    FIFTH(3, 5000, "3개 일치 (5000원)"),
    MISS(0, 0, "");

    private int countOfMatch;
    private int money;
    private String comment;

    PrizeGroup(int countOfMatch, int money, String comment) {
        this.countOfMatch = countOfMatch;
        this.comment = comment;
        this.money = money;
    }

    public String getComment() {
        return this.comment;
    }

    public int getMoney() {
        return this.money;
    }

    public int getCountOfMatch() {
        return this.countOfMatch;
    }

    public static PrizeGroup findRankByCountOfMatchAndBonus(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return Arrays.stream(PrizeGroup.values())
                .filter(prizeGroup -> prizeGroup.hasCountOfMatch(lottoTicket, winningLotto))
                .map(prizeGroup -> prizeGroup.findRankByBonus(lottoTicket, winningLotto))
                .findFirst()
                .orElse(PrizeGroup.MISS);
    }

    private boolean hasCountOfMatch(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return lottoTicket.checkRank(this.countOfMatch, winningLotto.getWinningLottoNumbers());
    }

    private PrizeGroup findRankByBonus(LottoTicket lottoTicket, WinningLotto winningLotto) {
        if (lottoTicket.isSecondRank(winningLotto)) {
            return PrizeGroup.THIRD;
        }
        return this;
    }

}
