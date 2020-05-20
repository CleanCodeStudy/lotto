package com.javabom.lotto.domain.ticket;

import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    // 여기서 LottoTickets.LOTTO_NUM_PICK_SIZE 변수를 가져와서 사용하려했으나,
    // 의존성문제가 걸려서 다시 선언하여 사용하였습니다.
    // 제 생각에는 숫자 선택 개수가 만약 바뀐다면, 여기서 꺼내쓰는게 맞다고 생각하지만
    // 로또의 경우에는 그럴 일이 없다고 판단하여 의존성때문에 재선언하여 사용하였습니다.
    // 이부분 리뷰 바랍니다.
    private static final int LOTTO_NUM_PICK_SIZE = 6;

    @Override
    public List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> numbers = SortedLottoNumbers.create();
        Collections.shuffle(numbers);
        return numbers.subList(0, LOTTO_NUM_PICK_SIZE);
    }
}
