package com.javabom.lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;

public class SortedLottoNumbers {

    public static List<LottoNumber> create() {
        ArrayList<LottoNumber> numbers = new ArrayList<>();
        for (int number = LottoNumber.MIN_LOTTO_NUM; number <= LottoNumber.MAX_LOTTO_NUM; number++) {
            numbers.add(new LottoNumber(number));
        }
        return numbers;
    }
}

// 처음엔 static 하나도 없는 일급 컬렉션으로 설계.
// 생성자로 1~45 들어가있는 List를 한 번 생성한 뒤 필요할때마다 복사본을 넘기게 설계.
// 한 번만 만들어내고 그다음부턴 복사본을 넘긴다.

// 지금은 부를 때 마다 새로 만들어준다.

// 무엇이 더 좋은지 모르겠습니다.
