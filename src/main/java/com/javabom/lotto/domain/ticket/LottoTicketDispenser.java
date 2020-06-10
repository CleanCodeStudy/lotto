package com.javabom.lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketDispenser {

    private static final Money LOTTO_TICKET_PRICE = new Money(1_000);

    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoTicketDispenser(LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    static public Money getTotalTicketPrice(int amount) {
        return LOTTO_TICKET_PRICE.multiply(amount);
    }

    public LottoTickets getAutoTickets(Money inputMoney) {
        int quantity = inputMoney.calculateQuantityPer(LOTTO_TICKET_PRICE);
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            LottoTicket lottoTicket = lottoTicketGenerator.getLottoTicket();
            tickets.add(lottoTicket);
        }
        return new LottoTickets(tickets);
    }

    public LottoTickets getManualTickets(Money inputMoney, List<ManualLottoNumbers> manualNumbers) {
        validateEnoughMoney(inputMoney, manualNumbers.size());
        return new LottoTickets(manualNumbers.stream()
                .map(ManualLottoNumbers::toLottoTicket)
                .collect(Collectors.toList()));
    }

    private void validateEnoughMoney(Money inputMoney, int quantity) {
        Money totalPrice = LOTTO_TICKET_PRICE.multiply(quantity);
        if (totalPrice.isBiggerThan(inputMoney)) {
            throw new IllegalStateException(String.format("%d개의 티켓을 사기에 돈이 모자랍니다. 넣은 금액 : %s", quantity, inputMoney.toString()));
        }
    }
    // 여기서 그냥 inputMoney.spend(totalPrice); 한줄만 때리려했는데, (spend 내부에 금액 검사 로직이 있어서)
    // 다른사람이 볼 때 이게뭐야? 할거같고, inputMoney내부의 상태값이 바뀌는듯한 인상을 주어
    // 이렇게 바꿨는데.. 어떻게 생각하시나요?
}
