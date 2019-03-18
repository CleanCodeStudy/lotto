package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoRankTest {

    @Test
    public void 맞춘개수_넣었을_때_올바른_ENUM_타입_리턴하기() {
        assertEquals(LottoRank.FIRST, LottoRank.findByCorrectRank(6));

    }
}