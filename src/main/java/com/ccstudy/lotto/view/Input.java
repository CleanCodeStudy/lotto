package com.ccstudy.lotto.view;

import java.io.InputStream;
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

    public List<Integer> inputCorrectAnswer(){


        System.out.println("지난주 담청 금액을 입력해주세요.");

        String[] correctAnswer =scanner.nextLine()
                .split(SPLITTER);

        return Arrays.stream(correctAnswer)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
