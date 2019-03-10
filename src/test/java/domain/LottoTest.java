package domain;

import org.junit.Test;
import util.FixedListGeneratorImpl;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LottoTest {

    @Test
    public void 몇개_맞췄는지() {
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl();
        Lotto myLotto = new Lotto(fixedListGenerator.getSixList());

        assertEquals(3, myLotto.getAnswer(Arrays.asList(1, 2, 11, 8, 3, 10)));
    }
}