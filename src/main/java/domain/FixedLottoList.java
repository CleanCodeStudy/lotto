package domain;

import java.util.List;

public class FixedLottoList extends LottoList {

    public FixedLottoList(int price, List<Lotto> lottoList) {
        super(price);
        super.setLottos(lottoList);
    }

}
