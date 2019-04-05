package dto;

import java.util.List;

public class WinningInputDto {
    private List<Integer> winningNumbers;
    private int bonus;

    public WinningInputDto(List<Integer> winningNumbers,int bonus){
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }
}
