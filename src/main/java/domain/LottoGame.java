package domain;

import dto.WinningNumberDto;
import dto.WinningResultDto;
import domain.vo.Money;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private List<LottoTicket> lottoTickets;
    private Money investment;

    public LottoGame(long money, List<String> manualLottos) {
        this.investment = new Money(money);
        this.lottoTickets = buyLotto(manualLottos);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private List<LottoTicket> buyLotto(List<String> manualLottos) {
        List<LottoTicket> lottoTickets = buyManualLottos(manualLottos);

        long amountOfAutoLotto = investment.getAmountOfLotto() - lottoTickets.size();

        for (int i = 0; i < amountOfAutoLotto; i++) {
            lottoTickets.add(LottoTicket.createAutoLotto());
        }

        return lottoTickets;
    }

    private List<LottoTicket> buyManualLottos(List<String> manualLottos){
        return manualLottos.stream()
                .map(LottoTicket::createManualLotto)
                .collect(Collectors.toList());
    }

    public WinningResultDto confirmLottos(WinningNumberDto winningNumberDto) {
        WinningNumbers winningNumbers = winningNumberDto.toEntity();

        List<Rank> lottoResults = matchLottoTickets(winningNumbers);

        return new WinningResultDto(lottoResults);
    }

    private List<Rank> matchLottoTickets(WinningNumbers winningNumbers){
        return lottoTickets.stream()
                .map(winningNumbers::confirm)
                .collect(Collectors.toList());
    }
}

