package com.ccstudy.lotto.view;

import com.ccstudy.lotto.domain.LottoTicket;
import com.ccstudy.lotto.domain.WinningNumber;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static Scanner scanner;
    public static final String SPLITTER = ",";

    public Input(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public InputDto purchaseLottos() {
        int purchaseAmount = inputPurchase();
        int manualAmountOfLotto = inputManualAmountOfLotto();
        List<String> manualLottoNumber = inputManualLottoNumber(manualAmountOfLotto);

        return new InputDto(purchaseAmount, manualAmountOfLotto, manualLottoNumber);
    }

    public WinningNumber inputWinningNumber() {
        List<Integer> correctAnswer = inputCorrectAnswer();
        int bonusNumber = inputBonusNumber();

        return new WinningNumber(correctAnswer, bonusNumber);
    }

    public int inputPurchase(){
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }


    public int inputManualAmountOfLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> inputManualLottoNumber(int manualAmoutOfLotto) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        List<String> manualLottoNumbers = new ArrayList<>();

        for (int i = 0; i < manualAmoutOfLotto; i++) {
            String inputNumbers = scanner.nextLine().replace(" ", "");

            manualLottoNumbers.add(inputNumbers);
        }

        return manualLottoNumbers;
    }

    public List<Integer> inputCorrectAnswer(){

        System.out.println("지난주 담청 번호를 입력해주세요.");

        String[] correctAnswer =scanner.nextLine()
                .replace(" ", "")
                .split(SPLITTER);

        return Arrays.stream(correctAnswer)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {

        System.out.println("보너스 볼을 입력해주세요.");

        return Integer.valueOf(scanner.nextLine());
    }
}
