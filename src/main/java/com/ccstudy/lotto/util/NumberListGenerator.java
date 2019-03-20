package com.ccstudy.lotto.util;

import java.util.ArrayList;
import java.util.List;

public interface NumberListGenerator {
    List<Integer> lottoRange = new ArrayList<>();

    List<Integer> getSixList();
}
