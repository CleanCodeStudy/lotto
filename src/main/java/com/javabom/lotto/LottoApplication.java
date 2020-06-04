package com.javabom.lotto;

import com.javabom.lotto.domain.dto.WinningStatisticsDto;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.result.WinningStatistics;
import com.javabom.lotto.domain.shop.LottoNumberShuffler;
import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.shop.LottoUser;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.ticket.WinningTicket;
import com.javabom.lotto.domain.vo.Money;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoShop lottoShop = new LottoShop(new LottoNumberShuffler());
        LottoUser lottoUser = new LottoUser(new Money(InputView.askInputMoney()), InputView.askManualNumberCount());

        LottoTickets manualTickets = lottoUser.buyTicketsByManualInLottoShop(lottoShop, InputView.askManualLottoNumbers(lottoUser.getManualLottoCount()));
        LottoTickets automaticTickets = lottoUser.buyTicketsByAutomaticInLottoShop(lottoShop);
        LottoTickets allTickets = manualTickets.joinTickets(automaticTickets);

        OutputView.printLotteryTickets(automaticTickets, manualTickets);

        WinningTicket winningTicket = new WinningTicket(InputView.askWinningTicket(), InputView.askBonusNumber());
        LottoResult lottoResult = allTickets.getLottoResult(winningTicket);
        WinningStatistics winningStatistics = new WinningStatistics(lottoResult);

        OutputView.printWinningStatistics(new WinningStatisticsDto(winningStatistics, lottoUser));
    }
}
