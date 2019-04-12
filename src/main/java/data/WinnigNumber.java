package data;

import model.LottoNum;
import model.LottoTicket;
import view.InputView;

public class WinnigNumber {

    private LottoTicket winnings;
    private LottoNum bonus;

    public WinnigNumber(InputView inputView){
        this.winnings = createWinnings(inputView.inputWinNumber());
        this.bonus = createBonus(inputView.inputBonus());
    }

    private LottoTicket createWinnings(String winnings){
        return new LottoTicket(winnings);
    }

    private LottoNum createBonus(int bonus){
        return new LottoNum(bonus);
    }

    public LottoTicket getWinnings() {
        return winnings;
    }

    public LottoNum getBonus() {
        return bonus;
    }
}
