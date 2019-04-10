package domain.LottoMachine;

import domain.LottoTicket;
import domain.bundle.LottoBundle;
import dto.InputDto;
import util.StringConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private static int LOTTO_DEFAULT_PRICE = 1000;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_CONTAIN_AMOUNT = 6;
    private static List<Integer> ALL_NUMBER;

    private InputDto inputDto;

    public LottoMachine(InputDto inputDto) {
        ALL_NUMBER = getAllNumbers();
        this.inputDto = inputDto;
    }

    public LottoBundle buyLottoTicket() {
        List<LottoTicket> randoms = makeRandomLottoTickets();
        List<LottoTicket> manuals = makeManualTickets();
        randoms.addAll(manuals);
        return new LottoBundle(randoms);
    }

    private List<LottoTicket> makeManualTickets() {
        if (inputDto.getManualAmount() == 0) {
            return new ArrayList<>();
        }

        return inputDto.getManuals().stream()
                .map(manualString -> StringConverter.stringToIntegerList(manualString))
                .map(numbers -> new LottoTicket(numbers, LottoTicket.MANUAL))
                .collect(Collectors.toList());
    }

    private List<LottoTicket> makeRandomLottoTickets() {
        int randomAmount = inputDto.getPrice() / LOTTO_DEFAULT_PRICE - inputDto.getManualAmount();

        return IntStream.range(0, randomAmount)
                .mapToObj(loop -> new LottoTicket(makeRandomNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> makeRandomNumbers() {

        Collections.shuffle(ALL_NUMBER);

        return ALL_NUMBER.stream()
                .limit(LOTTO_CONTAIN_AMOUNT)
                .collect(Collectors.toList());
    }

    private List<Integer> getAllNumbers() {
        return IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

}
