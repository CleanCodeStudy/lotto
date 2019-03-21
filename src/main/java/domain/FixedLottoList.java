package domain;

import java.util.List;

public class FixedLottoList extends LottoList {

    public FixedLottoList(List<Lotto> lottoList) {
        super(null);
        super.lottos=lottoList;
    }

}
