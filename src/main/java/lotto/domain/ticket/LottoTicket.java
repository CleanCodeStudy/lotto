package lotto.domain.ticket;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.domain.LottoGameProperty.COUNT_OF_LOTTO_NUMBER;

public class LottoTicket {
    private static final int BONUS_NUMBER_INDEX = 5;
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
        return Math.toIntExact(IntStream.range(0, COUNT_OF_LOTTO_NUMBER)
                .filter(index -> isSameLottoNumber(index, lottoTicket.lottoNumbers.get(index)))
                .count());
    }

    private boolean isSameLottoNumber(int index, LottoNumber lottoNumber) {
        return lottoNumbers.get(index).equals(lottoNumber);
    }

    public boolean hasBonusNumber(LottoNumber lottoNumber) {
        return isSameLottoNumber(BONUS_NUMBER_INDEX, lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
