package com.ccstudy.lotto.domain;

import com.ccstudy.lotto.view.InputDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    private List<LottoTicket> lottoTickets;

    public LottoGame(int purchase, InputDto inputDto) {
        this.lottoTickets = createLottos(purchase, inputDto);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public List<LottoTicket> createLottos(int purchase, InputDto inputDto) {
        int amountOfRandomLotto = purchase / LOTTO_PRICE - inputDto.getManualAmountOfLotto();

        List<LottoTicket> lottoTickets = new ArrayList<>();

        List<LottoTicket> manualLottoTickets = LottoMachine.createManualLottoTickets(inputDto.getManualLottoNumbers());
        List<LottoTicket> randomLottoTickets = LottoMachine.createRandomLottoTickets(amountOfRandomLotto);

        lottoTickets.addAll(manualLottoTickets);
        lottoTickets.addAll(randomLottoTickets);

        return lottoTickets;
    }

    public LottoResult gameStart(WinningNumber winningNumber) {
        return new LottoResult(lottoTickets, winningNumber);
    }
}
