package domain;

import java.util.List;

public class LottoTicket {
    private List<LottoNumber> numbers;

    public LottoTicket(List<String> numbers) {
        this.numbers = LottoNumber.getNumbers(numbers);
    }

    public LottoTicket(){
        this.numbers = LottoNumber.getNumbers();
    }

    public boolean hasNumber(int winningNumber) {
        return numbers.contains(winningNumber);
    }

    public static LottoTicket createAutoLotto(List<String> numbers){
        return new LottoTicket(numbers);
    }

    public static LottoTicket createMenualLotto(List<String> numbers){
        return new LottoTicket(numbers);
    }
}
