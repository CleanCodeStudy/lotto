package com.javabom.lotto.domain.dto;

public class ManualLottoCountDto {

    private int lottoCount;

    public ManualLottoCountDto(String lottoCount) {
        validNumberFormat(lottoCount);
        validNegativeNumber(lottoCount);
        this.lottoCount = Integer.parseInt(lottoCount);
    }

    private void validNegativeNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new IllegalArgumentException("음수 값을 입력했습니다.");
        }
    }

    private void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("정수가 아닌 값이 입력 되었습니다.");
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
