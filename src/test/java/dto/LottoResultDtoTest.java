package dto;

import domain.LottoMachine.LottoMachine;
import domain.prize.PrizeGroup;
import domain.WinningLotto;
import domain.bundle.LottoBundle;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultDtoTest {

    String manual1;
    String manual2;
    String manual3;
    String manual4;
    String manual5;
    String manual6;
    List<String> manuals;

    @Before
    public void 로또_준비() {
        manual1 = "1, 2, 3, 4, 5, 6";    //1
        manual2 = "3, 4, 5, 6, 7, 8";    //5
        manual3 = "5, 6, 7, 8, 9, 10";
        manual4 = "7, 8, 9, 10, 11, 12";
        manual5 = "9, 10, 11, 12, 13, 14";
        manual6 = "11, 12, 13, 14, 15, 16";
        manuals = Arrays.asList(manual1,
                manual2,
                manual3,
                manual4,
                manual5,
                manual6);
    }

    @Test
    public void 로또_가격_맞는지_확인하기() {
        //given
        int price = 6000;
        int manualAmount = 6;
        String bonus = "45";
        String winningnumbers = "1,2,3,4,5,6";
        WinningInputDto winningInputDto = new WinningInputDto(winningnumbers, bonus);
        WinningLotto winningLotto = winningInputDto.toWinningLotto();


        InputDto inputDto = new InputDto(price, manualAmount, manuals);


        //when

        LottoMachine random = new LottoMachine(inputDto);
        LottoMachine lottoMachine = new LottoMachine(inputDto);
        LottoBundle lottoBundle = lottoMachine.buyLottoTicket();
        LottoResultDto lottoResultDto = new LottoResultDto(lottoBundle, winningLotto);

        //then
        assertThat(lottoResultDto.getAllPrize()).isEqualTo(2000050000);
    }

    @Test
    public void 수익률_계산하기() {
        //given
        int price = 6000;
        int manualAmount = 6;
        double rate = (double) (2000050000 - 6000) / 6000 * 100;

        String bonus = "45";
        String winningnumbers = "1,2,3,4,5,6";
        WinningInputDto winningInputDto = new WinningInputDto(winningnumbers, bonus);
        WinningLotto winningLotto = winningInputDto.toWinningLotto();


        InputDto inputDto = new InputDto(price, manualAmount, manuals);


        //when
        LottoMachine random = new LottoMachine(inputDto);
        LottoMachine lottoMachine = new LottoMachine(inputDto);
        LottoBundle lottoBundle = lottoMachine.buyLottoTicket();
        LottoResultDto lottoResultDto = new LottoResultDto(lottoBundle, winningLotto);

        System.out.println("input money: " + lottoBundle.getInputMoney());
        System.out.println("input manual: " + lottoBundle.getManualAmount());
        System.out.println("input random: " + lottoBundle.getRandomAmount());

        //then
        assertThat(lottoResultDto.getRate()).isEqualTo(rate);
    }


    @Test
    public void 우승_로또랑_내가_수동으로_뽑은_로또_비교하기() {

        int price = 3000;
        int manualAmount = 3;
        String bonus = "7";
        String winningnumbers = "1,2,3,4,5,6";
        WinningInputDto winningInputDto = new WinningInputDto(winningnumbers, bonus);
        WinningLotto winningLotto = winningInputDto.toWinningLotto();


        String allMatchNumbers = "1, 2, 3, 4, 5, 6";
        String matchFive = "45, 2, 3, 4, 5, 6";
        String matchFiveWithBonus = "1, 2, 3, 4, 5, 7";

        List<String> customMunuals = Arrays.asList(allMatchNumbers, matchFive, matchFiveWithBonus);

        InputDto inputDto = new InputDto(price, manualAmount, customMunuals);

        LottoMachine lottoMachine = new LottoMachine(inputDto);
        LottoBundle lottoBundle = lottoMachine.buyLottoTicket();
        LottoResultDto lottoResultDto = new LottoResultDto(lottoBundle, winningLotto);


        List<PrizeGroup> expect = Arrays.asList(PrizeGroup.FIRST, PrizeGroup.FIRST, PrizeGroup.SECOND, PrizeGroup.THIRD);

        assertThat(lottoResultDto.getPrizeStat()).containsAll(expect);

    }
}