package util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeGroupTest {

    @Test
    public void 맞춘갯수에_맞는_상금객체_찾아오기() {
        int match = 3;
        Prize thirdPrize = PrizeGroup.findPrize(match);
        Prize expect = PrizeGroup.THREE.getPrize();

        assertThat(thirdPrize).isSameAs(expect);
    }
}