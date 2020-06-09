package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.List;

import static lotto.domain.LottoGameProperty.COUNT_OF_LOTTO_NUMBER;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또티켓은 중복되지않은 6개의 로또숫자로 이루어져야합니다.");
        }
    }

    public int getMatchCount(LottoTicket lottoTicket) {
        int matchCount = 0;
        for (int i = 0; i < COUNT_OF_LOTTO_NUMBER; i++) {
            if (lottoTicket.lottoNumbers.get(i).equals(this.lottoNumbers.get(i))) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean hasBonusNumber(LottoNumber lottoNumber) {
        return lottoNumbers.get(COUNT_OF_LOTTO_NUMBER - 1).equals(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
