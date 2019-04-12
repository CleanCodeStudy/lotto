package model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LottoNumTest {

    @Test
    public void LottoNum_생성하기() {
        assertEquals(1, new LottoNum(1).getNumber());
    }
}