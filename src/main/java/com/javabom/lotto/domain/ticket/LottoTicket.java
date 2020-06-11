package com.javabom.lotto.domain.ticket;

import com.javabom.lotto.domain.result.LottoRank;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validNumbers(this.lottoNumbers);
    }

    public static void validNumbers(List<LottoNumber> lottoNumbers) {
        validLottoNumberCount(lottoNumbers);
        validDuplicatedNumber(lottoNumbers);
    }

    private static void validDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        HashSet<LottoNumber> setNumbers = new HashSet<>(lottoNumbers);
        if (setNumbers.size() < LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또번호 중 중복된 번호가 존재합니다.");
        }
    }

    private static void validLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 로또 번호 수가 6개가 아닙니다.");
        }
    }

    public LottoRank findLottoRank(WinningTicket winningTicket) {
        int sameCount = getSameCount(winningTicket);
        boolean hasBonusNumber = winningTicket.isSameBonusNumber(getLastNumber());

        return LottoRank.findLottoRank(sameCount, hasBonusNumber);
    }

    private LottoNumber getLastNumber() {
        return getLottoNumbers().get(lottoNumbers.size() - 1);
    }

    private int getSameCount(WinningTicket winningTicket) {
        int sameCount = 0;
        List<LottoNumber> winningNumbers = winningTicket.getWinningNumbers();

        for (int i = 0; i < lottoNumbers.size(); i++) {
            boolean isSame = lottoNumbers.get(i).equals(winningNumbers.get(i));
            sameCount += (isSame ? 1 : 0);
        }

        return sameCount;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(getLottoNumbers(), that.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }
}
