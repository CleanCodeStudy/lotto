package domain.LottoMachine;

import domain.LottoNo;
import domain.LottoTicket;
import dto.InputDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoMachine extends LottoMachine {

    private static int LOTTO_DEFAULT_PRICE = 1000;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_CONTAIN_AMOUNT = 6;

    public RandomLottoMachine(InputDto inputDto) {
        super.inputDto = inputDto;
    }

    @Override
    public List<LottoTicket> buyLotto() {
        return makeRandomLottoTickets();
    }

    private List<LottoTicket> makeRandomLottoTickets() {
        int randomAmount = inputDto.getPrice() / LOTTO_DEFAULT_PRICE - inputDto.getManualAmount();

        return IntStream.range(0, randomAmount)
                .mapToObj(loop -> new LottoTicket(makeRandomNumbers()))
                .collect(Collectors.toList());
    }

    private List<LottoNo> makeRandomNumbers() {
        List<Integer> allLottoNumbers = getAllNumbers();

        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers.stream()
                .limit(LOTTO_CONTAIN_AMOUNT)
                .sorted()
                .map(number -> new LottoNo(number))
                .collect(Collectors.toList());
    }

    private List<Integer> getAllNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

}
