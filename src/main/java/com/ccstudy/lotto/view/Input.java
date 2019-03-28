package com.ccstudy.lotto.view;

import com.ccstudy.lotto.domain.Lotto;

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

    public int inputPurchase(){
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }


    public int inputManualAmountOfLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Lotto> inputManualLottoNumber(int manualAmoutOfLotto) {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < manualAmoutOfLotto; i++) {
            String inputNumbers = scanner.nextLine().replace(" ", "");

            String[] manualNumbers = inputNumbers.split(SPLITTER);

            Lotto lotto = new Lotto(Arrays.stream(manualNumbers)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList()));

            manualLottos.add(lotto);
        }

        return manualLottos;
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
