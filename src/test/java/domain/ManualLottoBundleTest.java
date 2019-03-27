package domain;

import domain.bundle.LottoBundle;
import domain.bundle.ManualLottoBundle;
import org.junit.Test;
import util.numberGenerator.FixedNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManualLottoBundleTest {

    @Test
    public void 수동3개_랜덤7개_섞어서_로또사기() {
        int price = 10000;

        LottoTicket ticket1 = new LottoTicket(new FixedNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTicket ticket2 = new LottoTicket(new FixedNumberGenerator(Arrays.asList(7, 8, 9, 10, 11, 12)));
        LottoTicket ticket3 = new LottoTicket(new FixedNumberGenerator(Arrays.asList(13, 14, 15, 16, 17, 18)));

        List<LottoTicket> manualTickets = new ArrayList<>();

        manualTickets.add(ticket1);
        manualTickets.add(ticket2);
        manualTickets.add(ticket3);

        LottoBundle lottoBundle = new ManualLottoBundle(price, manualTickets);

        lottoBundle.showList();

    }

}