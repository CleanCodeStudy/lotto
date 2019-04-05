package dto;

import domain.LottoTicket;

import java.util.List;

public class BuyLottoTicketDto {
    private List<LottoTicket> manualLottoTickets;
    private List<LottoTicket> randomLottoTickets;


    public BuyLottoTicketDto(List<LottoTicket> manualLottoTickets, List<LottoTicket> randomLottoTicketsLottoTickets) {
        this.manualLottoTickets = manualLottoTickets;
        this.randomLottoTickets = randomLottoTicketsLottoTickets;
    }

    public List<LottoTicket> getManualLottoTickets() {
        return manualLottoTickets;
    }

    public List<LottoTicket> getRandomLottoTickets() {
        return randomLottoTickets;
    }
}
