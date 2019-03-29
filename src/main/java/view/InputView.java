package view;

import domain.LottoTicket;
import domain.bundle.LottoBundle;
import domain.bundle.ManualLottoBundle;
import util.numberGenerator.FixedNumberGenerator;

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

    public LottoBundle getLottoBundle() {
        int price = getPrice();
        if (price < MIN_MONEY) throw new RuntimeException("최소 가격보다 적습니다.");

        int manualAmount = getManualAmount();

        List<LottoTicket> lottoTickets = getManualLottoTickets(manualAmount);
        LottoBundle lottoBundle = new ManualLottoBundle(price, lottoTickets);

        new OutputView().showBuyedList(lottoBundle);

        return lottoBundle;
    }

    private int getPrice() {
        System.out.println(
                "로또 1장의 가격은 1000원이다.\n" +
                        "구입금액을 입력해 주세요.\n");
        return Integer.parseInt(inputString());
    }

    private int getManualAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.valueOf(inputString());
    }

    private List<LottoTicket> getManualLottoTickets(int amount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        if (amount == ZERO_AMOUNT) {
            return lottoTickets;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int t = 0; t < amount; t++) {
            String line = inputString();
            List<Integer> numbers = convertStringToIntegerList(line);
            LottoTicket ticket = new LottoTicket(new FixedNumberGenerator(numbers));
            lottoTickets.add(ticket);
        }

        return lottoTickets;
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
