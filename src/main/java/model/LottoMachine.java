package model;

import util.NumberListGenerator;
import util.RandomListGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

import static model.LottoGame.LOTTO_PRICE;

public class LottoMachine {


    private List<LottoTicket> lottoTickets;

    public LottoMachine(int myPurchaseMoney, NumberListGenerator numberListGenerator){
        this.lottoTickets = makePurchaseLottoList(myPurchaseMoney, numberListGenerator);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private List<LottoTicket> makePurchaseLottoList(int myPurchaseMoney, NumberListGenerator numberListGenerator) {
        List<LottoTicket> purchaseLottoTickets = new ArrayList<>();
        int myPurchaseAmount = myPurchaseMoney / LOTTO_PRICE;
        for (int i = 0; i < myPurchaseAmount; i++) {
            LottoTicket myLottoTicket = new LottoTicket(numberListGenerator.getSixList());
            purchaseLottoTickets.add(myLottoTicket);
        }
        return purchaseLottoTickets;
    }


}
