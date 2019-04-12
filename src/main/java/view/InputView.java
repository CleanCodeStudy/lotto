package view;

import data.PurchaseInfo;
import model.LottoTicket;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;



public class InputView {

    public static Scanner sc;
    private static final int LOTTO_UNTI = 6;

    public InputView(InputStream inputStream) {
        sc = new Scanner(inputStream);
    }



    public int purchase() {
        System.out.println("로또 1장의 가격은 " + PurchaseInfo.LOTTO_PRICE + "원 이다.\n" +
                "구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public int getManualCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public List<String> inputManualLotto(int count){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<String> lottoTickets = new ArrayList<>();
        for(int i =0 ; i< count; i++){
            lottoTickets.add(sc.next());
        }
        return lottoTickets;
    }




    public String inputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.next();
    }

    public int inputBonus(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }


}
