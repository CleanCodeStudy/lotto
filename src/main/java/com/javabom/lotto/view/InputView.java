package com.javabom.lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private final Scanner sc;

    public InputView(Scanner sc) {
        this.sc = sc;
    }

    public int inputManualLottoTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String manualLottoTicketCount = sc.nextLine();
        checkEmpty(manualLottoTicketCount);
        return Integer.parseInt(manualLottoTicketCount);
    }

    public List<List<String>> inputManualLottoNumbers(int manualLottoTicketCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        List<List<String>> manualLottoNumbers = new ArrayList<>();
        for (int ticketCount = 1; ticketCount <= manualLottoTicketCount; ticketCount++) {
            String manualLottoNumber = sc.nextLine();
            checkEmpty(manualLottoNumber);
            manualLottoNumbers.add(Arrays.asList(manualLottoNumber.split(DELIMITER)));
        }
        return manualLottoNumbers;
    }

    public int inputMoney() {
        String FIRST_QUESTION = "구입 금앱을 입력해 주세요.";
        System.out.println(FIRST_QUESTION);
        String money = sc.nextLine();
        checkEmpty(money);
        return Integer.parseInt(money);
    }

    public List<String> inputPrizeNumbers() {
        String SECOUND_QUESTION = "당첨 번호를 입력해주세요.";
        System.out.println(SECOUND_QUESTION);
        String prizeNumbers = sc.nextLine();
        checkEmpty(prizeNumbers);
        return Arrays.asList(prizeNumbers.split(DELIMITER));
    }

    public String inputBonusNumber() {
        String THIRD_QUESTION = "보너스 번호를 입력해주세요.";
        System.out.println(THIRD_QUESTION);
        String bonusNumber = sc.nextLine();
        checkEmpty(bonusNumber);
        return bonusNumber;
    }

    private void checkEmpty(String inputValue) {
        if (inputValue.isEmpty()) {
            throw new NullPointerException("값을 입력하지 않았습니다. 값을 입력해 주세요.");
        }
    }
}
