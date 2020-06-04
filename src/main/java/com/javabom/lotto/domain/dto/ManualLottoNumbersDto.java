package com.javabom.lotto.domain.dto;

import com.javabom.lotto.domain.ticket.LottoNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoNumbersDto {

    List<Set<LottoNumber>> manualLottoNumbers;

    public ManualLottoNumbersDto(List<String> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers.stream()
                .map(LottoNumberSeparator::separate)
                .collect(Collectors.toList())
                .stream()
                .map(HashSet::new)
                .collect(Collectors.toList());
    }

    public List<Set<LottoNumber>> getManualLottoNumbers() {
        return manualLottoNumbers;
    }
}
