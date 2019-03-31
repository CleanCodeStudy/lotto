package domain.LottoMachine;

import domain.LottoTicket;
import dto.InputDto;
import dto.ManualNumberDto;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoMachine extends LottoMachine {

    public ManualLottoMachine(InputDto inputDto) {
        super.inputDto = inputDto;
    }

    @Override
    public List<LottoTicket> buyLotto() {
        return makeManualLottoTickets(inputDto.getManualNumberDtos());
    }

    private List<LottoTicket> makeManualLottoTickets(List<ManualNumberDto> manualNumbers) {
        return manualNumbers.stream()
                .map(manualNumberDto -> new LottoTicket(manualNumberDto.getLottoNos()))
                .collect(Collectors.toList());
    }
}
