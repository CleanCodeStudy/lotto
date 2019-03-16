package controller;

import model.Lotto;
import model.LottoGame;
import model.LottoRank;
import util.FixedListGeneratorImpl;
import util.RandomListGeneratorImpl;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;

    public void startLotto(){
        InputView inputView = new InputView(System.in);
        OutputView outputView = new OutputView();

        int myPurchasePrice = inputView.purchase();
        int lottoCount = myPurchasePrice/LOTTO_PRICE;

        List<Lotto> myLottos = getPurchaseLottoList(lottoCount);

        outputView.viewRandomNum(lottoCount);

        List<Integer> winNumbers = getWinNumbers(inputView.winNumber());

        Map<LottoRank, Integer> lottoResult = lottoResultAnalysis(myLottos,winNumbers);

    }

    public List<Lotto> getPurchaseLottoList(int purchaseCount){
        List<Lotto> purchaseLottos = new ArrayList<>();
        RandomListGeneratorImpl randomListGenerator = new RandomListGeneratorImpl();

        for (int i=0; i<3; i++){
            Lotto myLotto = new Lotto(randomListGenerator.getSixList());
            purchaseLottos.add(myLotto);
        }
        return  purchaseLottos;
    }

    public Map<LottoRank, Integer> lottoResultAnalysis(List<Lotto> purchaseLottos, List<Integer> winNumbers){
        LottoGame lottoGame = new LottoGame(purchaseLottos);
        return lottoGame.getResult(winNumbers);
    }

    public List<Integer> getWinNumbers(String winNumbers){
        return Arrays.asList(winNumbers.split(" "))
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

}
