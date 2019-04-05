package view;

import dto.InputDto;
import dto.ManualNumberDto;
import dto.WinningInputDto;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner;
    private static String SPLITTER = ",";
    private static int ZERO_AMOUNT = 0;
    private static int MIN_MONEY = 1000;

    public InputView(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    private String inputString() {
        return scanner.nextLine();
    }

    public InputDto getPriceAndManual(){
        int price = getPrice();

        int manualAmount = getManualAmount();

        List<ManualNumberDto> manualNumbers = getManualLottoNumbers(manualAmount);

        return new InputDto(price,manualAmount,manualNumbers);
    }

    public int getPrice() {
        System.out.println(
                "로또 1장의 가격은 1000원이다.\n" +
                        "구입금액을 입력해 주세요.\n");
        int price = Integer.parseInt(inputString());
        if (price < MIN_MONEY) throw new IllegalArgumentException("최소 가격보다 적습니다.");
        return price;
    }

    public int getManualAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int amount = Integer.valueOf(inputString());
        if (amount < 0) throw new IllegalArgumentException("0보다 작은값을 입력할 수 없습니다.");
        return amount;
    }

    public List<ManualNumberDto> getManualLottoNumbers(int amount) {
        if (amount == ZERO_AMOUNT) {
            return new ArrayList<>();
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<ManualNumberDto> manualNumberDtos = new ArrayList<>();
        for (int t = 0; t < amount; t++) {
            String line = inputString();
            List<Integer> numbers = convertStringToIntegerList(line);
            manualNumberDtos.add(new ManualNumberDto(numbers));
        }
        return manualNumberDtos;
    }

    public WinningInputDto getWinInputDto(){
        List<Integer> winNumbers = getWinningNumbers();
        int bonus = getBonusNumber();
        return new WinningInputDto(winNumbers,bonus);
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winningNumberLine = inputString();

        return convertStringToIntegerList(winningNumberLine);
    }

    public Integer getBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonus = inputString();
        return Integer.valueOf(bonus);
    }

    private List<Integer> convertStringToIntegerList(String src) {
        String[] srcArr = src
                .replace(" ", "")
                .split(SPLITTER);

        return Arrays.stream(srcArr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
