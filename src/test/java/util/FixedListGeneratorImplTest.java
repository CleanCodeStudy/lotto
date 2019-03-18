package util;

import model.Lotto;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;

public class FixedListGeneratorImplTest {


    @Test
    public void 고정된_6자리_리스트_생성() {
        FixedListGeneratorImpl fixedListGenerator = new FixedListGeneratorImpl();
        Lotto myLotto = new Lotto(fixedListGenerator.getSixList());

        assertThat(myLotto.getNumbers(), contains(1, 2, 3, 4, 5, 6));
    }
}