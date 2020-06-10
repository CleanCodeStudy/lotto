package com.javabom.lotto;

import com.javabom.lotto.domain.results.LottoLuckyNumbers;
import com.javabom.lotto.domain.results.LottoResults;
import com.javabom.lotto.domain.ticket.*;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Money inputMoney = new Money(InputView.getMoneyToBuyTicket());

        int manualLottoAmount = InputView.getManualLottoAmount();
        List<ManualLottoNumbers> manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoAmount);

        LottoTicketDispenser lottoTicketDispenser = new LottoTicketDispenser(new RandomLottoTicketGenerator());
        LottoTickets manualLottoTickets = lottoTicketDispenser.getManualTickets(inputMoney, manualLottoNumbers);
        Money restMoney = inputMoney.spend(LottoTicketDispenser.getTotalTicketPrice(manualLottoAmount));
        LottoTickets autoLottoTickets = lottoTicketDispenser.getAutoTickets(restMoney);
        OutputView.printLottoTickets(manualLottoTickets, autoLottoTickets);

        LottoTicket basicLuckyTicket = new LottoTicket(LottoNumberConverter.convert(InputView.getLottoBasicLuckyNumbers()));
        LottoNumber bonusNumber = new LottoNumber(InputView.getBonusNumber());
        LottoLuckyNumbers luckyNumbers = new LottoLuckyNumbers(basicLuckyTicket, bonusNumber);

        LottoTickets wholeLottoTickets = autoLottoTickets.add(manualLottoTickets);
        LottoResults lottoResults = wholeLottoTickets.getLottoResults(luckyNumbers);
        OutputView.printLottoResults(lottoResults);
        OutputView.printEarningRate(inputMoney, lottoResults.getTotalPrizeMoney());
    }
}
