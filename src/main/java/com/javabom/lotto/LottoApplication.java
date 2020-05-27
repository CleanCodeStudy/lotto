package com.javabom.lotto;

import com.javabom.lotto.domain.dto.WinningStatisticsDto;
import com.javabom.lotto.domain.result.LottoResult;
import com.javabom.lotto.domain.ticket.LottoTickets;
import com.javabom.lotto.domain.ticket.WinningTicket;
import com.javabom.lotto.domain.shop.LottoShop;
import com.javabom.lotto.domain.shop.LottoNumberShuffler;
import com.javabom.lotto.domain.shop.UserMoney;
import com.javabom.lotto.domain.result.WinningStatistics;
import com.javabom.lotto.view.InputView;
import com.javabom.lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        UserMoney userMoney = new UserMoney(InputView.askInputMoney());
        LottoTickets lottoTickets = LottoShop.buyTickets(userMoney, new LottoNumberShuffler());

        OutputView.printLotteryTickets(lottoTickets);

        WinningTicket winningTicket = new WinningTicket(InputView.askWinningTicket(), InputView.askBonusNumber());
        LottoResult lottoResult = lottoTickets.getLottoResult(winningTicket);
        WinningStatistics winningStatistics = new WinningStatistics(lottoResult);

        OutputView.printWinningStatistics(new WinningStatisticsDto(winningStatistics, userMoney));
    }
}
