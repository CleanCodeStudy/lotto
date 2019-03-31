package domain.LottoMachine;

import domain.LottoTicket;
import dto.InputDto;

import java.util.List;

public abstract class LottoMachine {

    protected InputDto inputDto;

    public abstract List<LottoTicket> buyLotto();


}
