package com.javabom.lotto;

import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.WinningStatistics;
import com.javabom.lotto.domain.shop.LottoNumbersGenerator;
import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.ticket.WinningTicket;
import com.javabom.lotto.domain.vo.Money;
import com.javabom.lotto.dto.InputDto;
import com.javabom.lotto.dto.WinningNumbersDto;
import com.javabom.lotto.dto.WinningStatisticsDto;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        InputDto inputDto = InputView.askInputMoneyAndManual();
        LottoShop lottoShop = new LottoShop(new LottoNumbersGenerator());

        LottoTickets manualTickets = lottoShop.buyTicketsByManualInLottoShop(inputDto.getManualNumbers());
        Money remainMoney = lottoShop.getRemainMoney(manualTickets, inputDto.getMoney());
        LottoTickets automaticTickets = lottoShop.buyTicketsByAutomaticInLottoShop(remainMoney);

        OutputView.printLotteryTickets(automaticTickets, manualTickets);
        WinningNumbersDto winningNumbersDto = InputView.askWinningNumbers();
        WinningTicket winningTicket = new WinningTicket(winningNumbersDto.getWinningNumbers(),
                winningNumbersDto.getBonusNumber());

        LottoTickets allTickets = manualTickets.joinTickets(automaticTickets);
        LottoResult lottoResult = allTickets.getLottoResult(winningTicket);

        OutputView.printWinningStatistics(new WinningStatisticsDto(new WinningStatistics(lottoResult)));
    }
}
