package com.javabom.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final String FIRST_QUESTION = "구입 금앱을 입력해 주세요.";
    private final String SECOUND_QUESTION = "당첨 번호를 입력해주세요.";
    private final String THIRD_QUESTION = "보너스 번호를 입력해주세요.";
    private final String DELIMITER = ", ";

    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public String inputMoney() {
        System.out.println(FIRST_QUESTION);
        String money = sc.nextLine();
        checkEmpty(money);
        return money;
    }

    public List<String> inputPrizeNumbers() {
        System.out.println(SECOUND_QUESTION);
        String prizeNumbers = sc.nextLine();
        checkEmpty(prizeNumbers);
        return Arrays.asList(prizeNumbers.split(DELIMITER));
    }

    public String inputBonusNumber() {
        System.out.println(THIRD_QUESTION);
        String bonusNumber = sc.nextLine();
        checkEmpty(bonusNumber);
        return bonusNumber;
    }

    private void checkEmpty(String inputValue) {
        if(inputValue.isEmpty()){
            throw new NullPointerException("값을 입력하지 않았습니다. 값을 입력해 주세요.");
        }
    }
}
