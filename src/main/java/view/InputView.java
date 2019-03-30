package view;

import model.LottoTicket;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static model.LottoGame.LOTTO_PRICE;

public class InputView {

    public static Scanner sc;
    private static final int LOTTO_UNTI = 6;

    public InputView(InputStream inputStream) {
        sc = new Scanner(inputStream);
    }

    public int getManualCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.\n");
        return sc.nextInt();
    }

    public List<LottoTicket> inputManualLotto(int count){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.\n");

        List<LottoTicket> lottoTickets = new ArrayList<>();
        for(int i =0 ; i< count; i++){
            String lottoTicket = sc.next();
            lottoTickets.add(new LottoTicket(makeNumberList(lottoTicket)));
        }
        return lottoTickets;
    }

    public int purchase() {
        System.out.println("로또 1장의 가격은 " + LOTTO_PRICE + "원 이다.\n" +
                "구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public List<Integer> inputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNumberString = sc.next();
        List<Integer> winNumberList = makeNumberList(winNumberString);
        System.out.println("보너스 볼을 입력해 주세요.");
        winNumberList.add(sc.nextInt());
        return winNumberList;
    }

    private List<Integer> makeNumberList(String winNumberString) {
        return Arrays.asList(winNumberString.split(","))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
