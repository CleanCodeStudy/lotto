package dto;

import domain.LottoNo;

import java.util.List;
import java.util.stream.Collectors;

public class ManualNumberDto {
    private List<LottoNo> lottoNos;

    public ManualNumberDto(List<Integer> numbers) {
        this.lottoNos = numbers.stream()
                .map(integer -> new LottoNo(integer))
                .collect(Collectors.toList());
    }

    public List<LottoNo> getLottoNos() {
        return lottoNos;
    }
}
