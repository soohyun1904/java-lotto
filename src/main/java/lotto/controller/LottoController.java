package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    public LottoController(){

    }

    private static final int TICKET_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static PlayerLottoAmount playerLottoAmount;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static WinningResult winningResult;
    public void run(){
        try{
            start();
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void start() {
        int ticketCount=inputPlayerAmount();
        OutputView.printTicketCount(ticketCount);
        lottoList = makeLottoList(ticketCount);
        winningResult=validateBonus();

        lottoResult(lottoList,winningResult,ticketCount);
    }

    private void lottoResult(List<Lotto> lottoList, WinningResult winningResult, int amount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printSucessResult();
        for(int i=0;i<lottoList.size();i++){
            rank = winningResult.match(lottoList.get(i));
            result.put(rank, result.get(rank)+1);
        }
        printResult(result);
        printEarningRate(result, amount);
    }

    private void printResult(Map<Ranking, Integer> result) {
        for(int i=Ranking.values().length-1;i>=0;i--){
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }


    public WinningResult validateBonus() {
        Lotto lotto =new Lotto(InputView.inputWinningNum());
        List<Integer> winningNumber=lotto.getNumbers();

        int ball = InputView.inputLottoBonusNum();
        lotto.validateBonusNumber(winningNumber, ball);
        winningResult = new WinningResult(new Lotto(winningNumber), ball);

        return winningResult;
    }

    private static List<Lotto> makeLottoList(int ticketCount) {
        lottoList=new ArrayList<>();
        for(int i=0;i<ticketCount;i++){
            lottoList.add(makeLotto());
        }
        return lottoList;
    }

    private static Lotto makeLotto() {
        LottoNumbers lottoNumbers =new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    public int inputPlayerAmount() {
        playerLottoAmount = new PlayerLottoAmount(InputView.inputPlayerAmount());
        return playerLottoAmount.calculateLottoCount();
    }
    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();

        for (Ranking rank : Ranking.values()){
            result.put(rank, 0);
        }
        return result;
    }
    private void printEarningRate(Map<Ranking, Integer> result, int lottoAmount) {
        double EarningRate = 0;
        for (Ranking rank : result.keySet()) {
            EarningRate =
                    EarningRate + ((double) (rank.getWinningAmount()) / (lottoAmount * TICKET_PRICE) * (result.get(
                            rank)) * (PERCENTAGE));

        }
        OutputView.printRevenueRate(EarningRate);
    }
}
