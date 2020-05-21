package com.javabom.lotto.view;

import com.javabom.lotto.domain.LottoTickets;

public class OutputView {

    private OutputView() {
    }

    public void printNumberOfLottoTickets(final int numberOfTickets) {
        System.out.printf("%d개를 구매했습니다", numberOfTickets);
    }

    public void printRandomLottoNumber(final LottoTickets lottoTickets) {

    }
}
