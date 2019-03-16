package util;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

public class RandomListGeneratorTest {


    @Test
    public void 임의의_6자리_랜덤_리스트_생성() {
        RandomListGeneratorImpl randomListGenerator = new RandomListGeneratorImpl();

        List<Integer> random6 = randomListGenerator.getSixList();
        assertThat(random6, hasSize(6));
    }
}