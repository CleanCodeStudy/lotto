package dto;

import domain.WinningNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberDto {
    private List<Integer> winningNumbers;
    private int bonusBall;

    public WinningNumberDto(String winningNumbers, String bonusBall) {
        this.winningNumbers = parseNumbers(winningNumbers);
        this.bonusBall = Integer.parseInt(bonusBall);;
    }

    private List<Integer> parseNumbers(String numbers){
        String[] splitNum = numbers.split(",");

        return Arrays.stream(splitNum)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public WinningNumbers toEntity(){
        return new WinningNumbers(winningNumbers,bonusBall);
    }
}
