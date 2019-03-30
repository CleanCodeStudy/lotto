package model;

import util.NumberListGenerator;
import util.RandomListGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

import static model.LottoGame.LOTTO_PRICE;

public class LottoMachine {


    private List<LottoTicket> lottoTickets;
    private int autoLottoTicketCount;
    private int manualLottoTicektCount;

    public LottoMachine(int myPurchaseMoney, List<LottoTicket> manualLottos ,NumberListGenerator numberListGenerator){
        this.autoLottoTicketCount = calculateAutoCount(myPurchaseMoney, manualLottos);
        this.manualLottoTicektCount = manualLottos.size();
        this.lottoTickets = makePurchaseLottoList(manualLottos,numberListGenerator);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int getAutoLottoTicketCount() {
        return autoLottoTicketCount;
    }

    public int getManualLottoTicektCount() {
        return manualLottoTicektCount;
    }

    private int calculateAutoCount(int myPurchaseMoney, List<LottoTicket> manualLottos){
        int myPurchaseAmount = myPurchaseMoney / LOTTO_PRICE;
        return myPurchaseAmount - manualLottos.size();
    }

    private List<LottoTicket> makePurchaseLottoList(List<LottoTicket>manualLottos, NumberListGenerator numberListGenerator) {
        List<LottoTicket> purchaseLottoTickets = manualLottos;
        for (int i = 0; i < autoLottoTicketCount; i++) {
            LottoTicket myLottoTicket = new LottoTicket(numberListGenerator.getSixList());
            purchaseLottoTickets.add(myLottoTicket);
        }
        return purchaseLottoTickets;
    }


}
