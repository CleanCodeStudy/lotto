package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoTicket {
    private List<LottoNum> numbers = new ArrayList<>();

    public LottoTicket(String manualString) { //make Manual
        createManualLottoNums(manualString);
    }

    public LottoTicket() { //make Random
        createRandomLottoNums();
    }

    public int getCollectCount(LottoTicket correctAnswer) {
        return (int) numbers.stream()
                .filter(correctAnswer::contains)
                .count();
    }

    public int size() {
        return numbers.size();
    }

    public void printList() {
        String str = "[" + numbers.stream()
                .map(num -> "" + num.getNumber())
                .collect(Collectors.joining(",")) + "]";
        System.out.println(str);
    }

    public boolean contains(LottoNum lottoNum) {

        int checkNum = lottoNum.getNumber();
        List<Integer> checking = numbers.stream()
                .map(x -> x.getNumber())
                .collect(Collectors.toList());

        return checking.contains(checkNum);
    }

    private List<Integer> makeIntegerManualNumbers(String inputNums) {
        return Arrays.asList(inputNums.split(","))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private void createManualLottoNums(String inputNums) {
        for (Integer lottoNum : makeIntegerManualNumbers(inputNums)) {
            addNum(lottoNum);
        }
    }

    private void createRandomLottoNums() {
        for (Integer lottoNum : makeIntegerRandomNumbers()) {
            addNum(lottoNum);
        }
    }

    private void addNum(int lottoNumber) {
        numbers.add(new LottoNum(lottoNumber));
    }

    private List<Integer> makeIntegerRandomNumbers() {
        List<Integer> randoms = IntStream.range(LottoNum.MIN_LOTTO_NUM, LottoNum.MAX_LOTTO_NUM)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        Collections.shuffle(randoms);

        return randoms.stream()
                .limit(6)
                .collect(Collectors.toList());
    }

}
