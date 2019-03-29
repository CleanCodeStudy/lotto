package util;

import model.LottoTicket;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class FixedListGeneratorImplTest {


    @Test
    public void 고정된_6자리_리스트_생성() {
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl();
        LottoTicket myLottoTicket = new LottoTicket(fixedListGenerator.getSixList());

        assertThat(myLottoTicket.getNumbers(), contains(1, 2, 3, 4, 5, 6));
    }
}