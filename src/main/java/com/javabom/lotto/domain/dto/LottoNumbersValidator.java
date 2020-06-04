package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;
import com.javabom.lotto.domain.ticket.LottoNumberSetting;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbersValidator {

    public static void validDuplicatedNumber(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> set = new HashSet<>(lottoNumbers);
        if (set.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호 중 중복된 번호가 존재합니다.");
        }
    }

    public static void validLottoNumberCount(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LottoNumberSetting.MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException("입력된 로또 번호 수가 6개가 아닙니다.");
        }
    }
}
